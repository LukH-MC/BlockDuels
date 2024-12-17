package lukh.blockDuels.commands.battle;

import lukh.blockDuels.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class addPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //CHECKS
        if( args.length != 1 ) {
            sender.sendMessage(Color.red + "You need to state one (1) player!");
            return false;
        }

        if (Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(Color.red + "Player not found!");
            return false;
        }
        else {
            if (!Objects.requireNonNull(Bukkit.getPlayer(args[0])).isConnected()) {//No Nullpointer possible due to above statement
                sender.sendMessage(Color.red + "Player is not online!");
                return false;
            }
        }
        //END OF CHECKS

        if (Game.running) {
            sender.sendMessage(Color.red + "A battle is already running!");
            return false;
        }

        if (Game.playerCount >= 2) {
            sender.sendMessage(Color.red + "There are already enough players!");
            return false;
        }
        if (Game.playerCount == 0) {
            Game.player1.setPlayer(Bukkit.getPlayer(args[0]));
            sender.sendMessage(Color.green + "Player " + Objects.requireNonNull(Bukkit.getPlayer(args[0])).getName() + " added!");
            Game.playerCount++;
        }
        if (Game.playerCount == 1) {
            Game.player2.setPlayer(Bukkit.getPlayer(args[0]));
            sender.sendMessage(Color.green + "Player " + Objects.requireNonNull(Bukkit.getPlayer(args[0])).getName() + " added!");
            Game.playerCount++;
        }

        return true;
    }
}
