package lukh.blockDuels.game;

import org.bukkit.entity.Player;

public class GamePlayer {
    private Player player = null;
    private int health = 10;
    private String[] effects;




    public Player getPlayer() {
        return this.player;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void changeHealth(int change) {
        this.health += change;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void removePlayer() {
        this.player = null;
    }


}
