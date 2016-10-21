package controller.internetActions.emailActions;


import java.io.IOException;
import java.util.Properties;

import static model.app_db.constants.MyConstants.PATH_TO_PROPERTIES_FILE;

public class PropertiesContainerLoader {

    private static Properties properties = load();

    private static Properties load() {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesContainerLoader.class.getResourceAsStream(PATH_TO_PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static Properties getProperties() {
        return properties;
    }
}
