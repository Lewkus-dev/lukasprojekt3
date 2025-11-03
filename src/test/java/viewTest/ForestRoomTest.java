package viewTest;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import se.sprinto.hakan.adventuregame.model.ForestRoom;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.Room;
import se.sprinto.hakan.adventuregame.view.UI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForestRoomTest implements Room {

    FakeUI fakeUi = new FakeUI();
    Player player = new Player.Builder()
            .setName("name")
            .setHealth(100)
            .setScore(0)
            .setStrength(100)
            .build();

    ForestRoom forestRoom = new ForestRoom();

    @Test
    public void findKeyTest(){
        fakeUi.setInput("ja");
        forestRoom.enterRoom(player, fakeUi);
        assertTrue(player.hasFoundKey());

    }

    @Override
    public void enterRoom(Player player, UI ui) {

    }
}
