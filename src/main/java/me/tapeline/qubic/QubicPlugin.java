package me.tapeline.qubic;

import me.tapeline.qubic.commands.QubicCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class QubicPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        AppManager.ensureAppFolderExists();
        Objects.requireNonNull(getCommand("qubic")).setExecutor(new QubicCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
