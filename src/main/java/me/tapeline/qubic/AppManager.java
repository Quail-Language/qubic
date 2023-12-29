package me.tapeline.qubic;

import me.tapeline.quailj.io.DefaultIO;
import me.tapeline.quailj.lexing.Lexer;
import me.tapeline.quailj.lexing.LexerException;
import me.tapeline.quailj.lexing.Token;
import me.tapeline.quailj.parsing.Parser;
import me.tapeline.quailj.parsing.ParserException;
import me.tapeline.quailj.parsing.nodes.sections.BlockNode;
import me.tapeline.quailj.preprocessing.Preprocessor;
import me.tapeline.quailj.preprocessing.PreprocessorException;
import me.tapeline.quailj.runtime.RuntimeStriker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.bukkit.Bukkit;
import org.checkerframework.checker.units.qual.A;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AppManager {

    public static List<QubicApp> loadedApps = new ArrayList<>();

    public static void ensureAppFolderExists() {
        if (!new File("apps").exists())
            new File("apps").mkdirs();
    }

    public static List<String> getInstalledApps() {
        String[] apps = new File("apps").list();
        if (apps == null) return new ArrayList<>();
        return Arrays.asList(apps);
    }

    public static List<String> getEnabledApps() {
        return getInstalledApps().stream().filter(s -> !s.startsWith("-")).collect(Collectors.toList());
    }

    public static void reloadAppFiles() {
        loadedApps = getEnabledApps().stream()
                .map(name -> new QubicApp(name, new File("apps/" + name + "/app.yml")))
                .collect(Collectors.toList());
    }

    public static void stopApp(String name) {
        for (QubicApp app : loadedApps)
            if (app.getName().equals(name)) {
                app.getApplicationThread().interrupt();
                break;
            }
    }

    public static void stopApps() {
        for (QubicApp app : loadedApps)
            app.getApplicationThread().interrupt();
    }

    public static QubicApp getLoadedApp(String name) {
        for (QubicApp app : loadedApps)
            if (app.getName().equals(name))
                return app;
        return null;
    }

    public static void startApp(QubicApp app)
            throws IOException, PreprocessorException, LexerException, ParserException {
        if (app == null)
            throw new IllegalArgumentException("App is null");
        String code = FileUtils.readFileToString(
                new File("apps/" + app.getName() + "/" + app.getMainScript()), "UTF-8");
        Preprocessor preprocessor = new Preprocessor(code, new File("apps/" + app.getName()));
        code = preprocessor.preprocess();
        Lexer lexer = new Lexer(code);
        List<Token> tokens = lexer.scan();
        Parser parser = new Parser(code, tokens);
        BlockNode mainNode = parser.parse();
        QubicRuntime runtime = new QubicRuntime(
                mainNode,
                code,
                new File("apps/" + app.getName() + "/" + app.getMainScript()),
                new File("apps/" + app.getName()),
                new DefaultIO(),
                false,
                false
        );
        Thread runtimeThread = new Thread(() -> {
            try {
                runtime.run(mainNode, runtime.getMemory());
                if (runtime.getMemory().get("onStart").isFunc())
                    runtime.getMemory().get("onStart").call(runtime, new ArrayList<>(), new HashMap<>());
            } catch (RuntimeStriker e) {
                throw new RuntimeException(e);
            }
        });
        runtimeThread.setName("Qubic App " + app.getName());
        runtimeThread.start();
        app.setApplicationThread(runtimeThread);
        app.setApplicationRuntime(runtime);
    }

    public static void startApp(String name)
            throws PreprocessorException, ParserException, IOException, LexerException {
        startApp(getLoadedApp(name));
    }

    public static void startAllLoadedApps()
            throws PreprocessorException, ParserException, IOException, LexerException {
        for (QubicApp app : loadedApps)
            startApp(app);

    }

}
