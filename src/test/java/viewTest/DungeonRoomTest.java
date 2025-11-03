package viewTest;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.DungeonRoom;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.Room;
import se.sprinto.hakan.adventuregame.view.UI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DungeonRoomTest implements Room {

    FakeUI fakeUi = new FakeUI();
    DungeonRoom dungeonRoom = new DungeonRoom();
    Player player = new Player.Builder()
            .setName("name")
            .setHealth(100)
            .setScore(0)
            .setStrength(100)
            .build();
    @Test
    public void dungeonRoomTest(){
        fakeUi.setInput("a");
        dungeonRoom.enterRoom(player, fakeUi);
        assertTrue(player.hasDefeatedEnemy());
    }

    @Override
    public void enterRoom(Player player, UI ui) {

    }
}
