package me.tapeline.qubic.commands;

import me.tapeline.quailj.lexing.LexerException;
import me.tapeline.quailj.parsing.ParserException;
import me.tapeline.quailj.preprocessing.PreprocessorException;
import me.tapeline.qubic.AppManager;
import me.tapeline.qubic.QubicApp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class QubicCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
                             @NotNull String commandString, @NotNull String[] args) {
        if (args.length == 0) return false;
        if (args[0].equalsIgnoreCase("info")) {
            commandSender.sendMessage("Qubic v1.0", "Quail-qre v2.0-alpha4", "© Tapeline 2021-2023");
        } else if (args[0].equalsIgnoreCase("list")) {
            commandSender.sendMessage("Enabled apps:");
            commandSender.sendMessage(AppManager.getEnabledApps().toArray(new String[0]));
        } else if (args[0].equalsIgnoreCase("reload")) {
            AppManager.stopApps();
            AppManager.reloadAppFiles();
            try {
                AppManager.startAllLoadedApps();
            } catch (PreprocessorException | ParserException | IOException | LexerException e) {
                commandSender.sendMessage("Exception occurred during reload:");
                commandSender.sendMessage(e.toString(), e.getMessage());
            }
        } else if (args[0].equalsIgnoreCase("stop")) {
            QubicApp app = AppManager.getLoadedApp(args[1]);
            if (app == null) commandSender.sendMessage("App not found");
            else {
                AppManager.stopApp(app.getName());
                commandSender.sendMessage("App stopped");
            }
        } else if (args[0].equalsIgnoreCase("stopall")) {
            AppManager.stopApps();
            commandSender.sendMessage("All apps stopped");
        }
        return true;
    }

}
