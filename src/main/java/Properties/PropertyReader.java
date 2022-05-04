package Properties;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;
    private String propertyName;


    public PropertyReader(String propertyName) {
        this.propertyName = propertyName;
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/" + this.propertyName + ".properties");
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
