package lukh.blockDuels;

import lukh.blockDuels.commands.battle.addPlayer;
import lukh.blockDuels.commands.battle.listPlayers;
import lukh.blockDuels.commands.battle.removePlayer;
import lukh.blockDuels.commands.game.startDuel;
import lukh.blockDuels.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("UnstableApiUsage")
public final class Main extends JavaPlugin {
    public Game game;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("BlockDuels enabled!");


        //imports
        newCommand("addPlayer", new addPlayer());
        newCommand("removePlayer", new removePlayer());
        newCommand("listPlayers", new listPlayers());
        newCommand("startDuel", new startDuel());
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
