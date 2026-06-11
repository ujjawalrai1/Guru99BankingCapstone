package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;
    
    public static String customerId;
    public static String accountId;

    public ConfigReader() {

        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config.properties");

            prop.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return prop.getProperty("url");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}