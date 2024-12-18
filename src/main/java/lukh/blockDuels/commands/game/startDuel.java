package lukh.blockDuels.commands.game;

import lukh.blockDuels.game.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class startDuel implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (Game.player1 == null && Game.player2 == null) {
            commandSender.sendMessage(ChatColor.RED + "You are missing players!");
            return false;
        }

        return true;
    }
}
