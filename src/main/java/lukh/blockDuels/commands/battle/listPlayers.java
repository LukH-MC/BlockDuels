package lukh.blockDuels.commands.battle;

import lukh.blockDuels.game.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class listPlayers implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String player1;
        String player2;
        if (Game.player1.getPlayer() == null){
            player1 = "Not registered";
        } else {
            player1 = Game.player1.getPlayer().getName();
        }
        if (Game.player2.getPlayer() == null){
            player2 = "Not registered";
        } else {
            player2 = Game.player2.getPlayer().getName();
        }
        commandSender.sendMessage(ChatColor.GOLD + "Player 1: " + player1 + "\nPlayer 2: " + player2);

        return true;
    }
}
