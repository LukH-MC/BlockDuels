package lukh.blockDuels;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("BlockDuels enabled!");


        //imports
        newCommand("addPlayer", addPlayer);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /** Registrierung neuer Events
     * @param eventFile Datei zur Verarbeitung des Events
     */
    private void newEvent(Listener eventFile) {
        Bukkit.getPluginManager().registerEvents(eventFile, this);
    }

    /** Registrierung neuer Commands
     * @param command Command-Name
     * @param cmdFile Die Datei zur Verarbeitung des Befehls, bitte in Commands-Ordner
     */
    private void newCommand(String command, CommandExecutor cmdFile) {
        PluginCommand pluginCommand = getCommand(command);

        if (pluginCommand != null) pluginCommand.setExecutor(cmdFile);
        else Bukkit.getLogger().warning("Befehl '" + command + "' konnte nicht registriert werden - Prüfe die yml und Code");
    }
}
