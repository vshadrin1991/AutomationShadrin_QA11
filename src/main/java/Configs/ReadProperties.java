package Configs;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private String propertyName;
    private Properties properties;

    public ReadProperties(String propertyName) {
        this.propertyName = propertyName;
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(this.propertyName + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
