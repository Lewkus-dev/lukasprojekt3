package viewTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.Room;
import se.sprinto.hakan.adventuregame.model.TreasureRoom;
import se.sprinto.hakan.adventuregame.view.UI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreasureRoomTest implements Room {

    FakeUI fakeUi = new FakeUI();
    TreasureRoom treasureRoom = new TreasureRoom();
    Player player = new Player.Builder()
            .setName("name")
            .setHealth(100)
            .setScore(0)
            .setStrength(100)
            .build();

    @Test
    public void treasuerRoomTest(){
        fakeUi.setInput("ja");
        player.setFoundKey(true);
        treasureRoom.enterRoom(player, fakeUi);
        assertTrue(player.hasOpenedChest());
    }
    @Override
    public void enterRoom(Player player, UI ui) {

    }
}
