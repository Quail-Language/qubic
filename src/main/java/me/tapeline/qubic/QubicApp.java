package me.tapeline.qubic;

import me.tapeline.quailj.runtime.Runtime;
import org.apache.commons.io.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class QubicApp {

    private String name;
    private File packageFile;
    private Runtime applicationRuntime;
    private Thread applicationThread;
    private String mainScript = "main.q";

    public QubicApp(String name, File packageFile) {
        this.name = name;
        this.packageFile = packageFile;
        loadConfig();
    }

    public void loadConfig() {
        Yaml yaml = new Yaml();
        try {
            Map<String, Object> packageCfg = yaml.load(FileUtils.readFileToString(
                    packageFile, "UTF-8"
            ));
            mainScript = packageCfg.get("main").toString();
            if (mainScript == null)
                throw new IllegalArgumentException("main attr for app " + name + " is null");
        } catch (IOException ignored) { }
    }

    public String getName() {
        return name;
    }

    public File getPackageFile() {
        return packageFile;
    }

    public Runtime getApplicationRuntime() {
        return applicationRuntime;
    }

    public void setApplicationRuntime(Runtime applicationRuntime) {
        this.applicationRuntime = applicationRuntime;
    }

    public Thread getApplicationThread() {
        return applicationThread;
    }

    public void setApplicationThread(Thread applicationThread) {
        this.applicationThread = applicationThread;
    }

    public String getMainScript() {
        return mainScript;
    }

}
