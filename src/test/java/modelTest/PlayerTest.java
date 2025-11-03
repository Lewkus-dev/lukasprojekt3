package modelTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Enemy;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    Enemy enemy = new Enemy("bade", 15, 2, 4);
    Player player = new Player.Builder()
            .setName("name")
            .setHealth(100)
            .setScore(0)
            .setStrength(4)
            .build();
    @Test
    public void playerAttackTest(){
        int enemyHealth = enemy.getHealth();
        int playerStrength = player.getStrength();
        int result = enemyHealth - playerStrength;
        player.attack(enemy);
        assertEquals(enemy.getHealth(), result);
    }


}
