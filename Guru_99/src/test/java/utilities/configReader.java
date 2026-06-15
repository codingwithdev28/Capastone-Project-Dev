package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class configReader {

    static Properties prop = new Properties();

    static {
        try {
            FileInputStream fis =new FileInputStream("src/test/resources/config.properties");

            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return prop.getProperty("url");
    }

    public static String getUsername() {
        return prop.getProperty("username");
    }

    public static String getPassword() {
        return prop.getProperty("password");
    }
}