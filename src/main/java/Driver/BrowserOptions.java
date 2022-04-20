package Driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;
import java.util.List;

import static Properties.PropertyReader.getProperties;

public class BrowserOptions<T> {

    public T getBrowserOptions(DriverManagerType driverManagerType) {
        String options = getProperties().getProperty(driverManagerType.name().toLowerCase() + ".options");
        List<String> listOptions = Arrays.asList(options.split(","));
        switch (driverManagerType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(listOptions);
                return (T) chromeOptions;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return (T) firefoxOptions;
            case EDGE:
                return null;
        }
        return null;
    }
}
