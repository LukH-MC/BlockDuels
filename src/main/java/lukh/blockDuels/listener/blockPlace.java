package lukh.blockDuels.listener;

import lukh.blockDuels.game.Game;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockPlace implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (!Game.running) {
            return;
        }
        if (Game.running && (e.getPlayer() != Game.player1.getPlayer() || e.getPlayer() != Game.player2.getPlayer())) {
            return;
        }




    }
}
