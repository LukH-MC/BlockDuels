package lukh.blockDuels.listener;

import lukh.blockDuels.game.Game;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class itemUse implements Listener {
    @EventHandler
    public void itemUse(PlayerItemConsumeEvent e) {
        if (!Game.running) {
            return;
        }
        if (Game.running && (e.getPlayer() != Game.player1.getPlayer() || e.getPlayer() != Game.player2.getPlayer())) {
            return;
        }

    }
}
