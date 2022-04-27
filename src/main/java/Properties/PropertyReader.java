package Properties;

import org.testng.ITestContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public final class PropertyReader {
    private static Properties properties;

    public PropertyReader(ITestContext context) {
        String propertyName = context.getSuite().getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config");
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/" + propertyName + ".properties");
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
