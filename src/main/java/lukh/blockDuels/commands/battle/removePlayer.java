package lukh.blockDuels.commands.battle;

import lukh.blockDuels.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class removePlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (Game.running) {
            commandSender.sendMessage("Game is already running!");
            return false;
        }
        if (args.length != 1) {
            commandSender.sendMessage("You need to state one (1) player!");
            return false;
        }
        if (Bukkit.getPlayer(args[0]) == null) {
            commandSender.sendMessage("Player not found!");
            return false;
        }
        if (args[0].equals(Game.player1.getPlayer().getName())) {
            Game.player1.removePlayer();
            commandSender.sendMessage("Player removed!");
            return true;
        }
        if (args[0].equals(Game.player2.getPlayer().getName())) {
            Game.player2.removePlayer();
            commandSender.sendMessage("Player removed!");
            return true;
        }

        return false;
    }
}
