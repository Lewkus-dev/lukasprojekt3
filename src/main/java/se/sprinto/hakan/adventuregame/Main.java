package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.StartRoom;
import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.service.StatisticsService;
import se.iths.lukas.adventuregame.util.AppInfo;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {
        AppInfo appInfo = AppInfo.getInstance();
        UI ui = new ScannerUI();
        ui.showMessage("Välkommen till Äventyrsspelet!");
        appInfo.showInfo(ui, appInfo);
        String name = ui.getInput("Ange ditt namn:");

        Player player = new Player.Builder()
                .setName(name)
                .setHealth(100)
                .setScore(0)
                .setStrength(100)
                .build();

        if(player != null){
            System.out.println("We have a player!");
        } else {
            System.out.println("No player found");
        }

        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        assert player != null;
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

