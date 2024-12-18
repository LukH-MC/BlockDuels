package lukh.blockDuels.commands.battle;

import lukh.blockDuels.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static org.bukkit.ChatColor.*;

public class addPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //CHECKS
        if( args.length != 1 ) {
            sender.sendMessage(RED + "You need to state one (1) player!");
            return false;
        }

        if (Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(RED + "Player not found!");
            return false;
        }
        else {
            if (!Objects.requireNonNull(Bukkit.getPlayer(args[0])).isConnected()) {//No Nullpointer possible due to above statement
                sender.sendMessage(RED + "Player is not online!");
                return false;
            }
        }
        if (Game.running) {
            sender.sendMessage(RED + "A battle is already running!");
            return false;
        }
        if (Game.player1.getPlayer() != null && Game.player2.getPlayer() != null) {
            sender.sendMessage(RED + "Battle is already full (2 players)!");
            return false;
        }
        //END OF CHECKS


        if (Game.player1.getPlayer() == null) {
            Game.player1.setPlayer(Bukkit.getPlayer(args[0]));
            sender.sendMessage(args[0] + " has been entered to the game!");
            return true;
        }
        if (Game.player2.getPlayer() == null && Game.player1.getPlayer() != null) {
            Game.player2.setPlayer(Bukkit.getPlayer(args[0]));
            sender.sendMessage(args[0] + " has been entered to the game!");
            return true;
        }

        return true;
    }
}
