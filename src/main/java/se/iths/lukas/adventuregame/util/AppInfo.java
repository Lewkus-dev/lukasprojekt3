package se.iths.lukas.adventuregame.util;


import se.sprinto.hakan.adventuregame.view.UI;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppInfo {
    private static AppInfo instance;
    private Properties properties;

    private AppInfo(){
        properties = new Properties();
        try (FileReader reader = new FileReader("properties")) {
            properties.load(reader);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppInfo getInstance(){
        if (instance == null) {
            instance = new AppInfo();
        }
        return instance;
    }

    public String getProperties(String key){
        return properties.getProperty(key);
    }


    public void showInfo(UI ui, AppInfo appInfo){
        ui.showMessage("Version " + appInfo.getProperties("version") + " av " + appInfo.getProperties("author") + ".");
    }
}
