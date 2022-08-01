package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static PropertiesHelper.PropertyReader.getProperties;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver webDriver;
        try {
            if (getProperties().containsKey("chrome.options") && !getProperties().containsKey("remote")) {
                WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments(getProperties().getProperty("chrome.options").split(","));
                webDriver = new ChromeDriver(chromeOptions);
            } else if (getProperties().containsKey("chrome.options") && getProperties().containsKey("remote")) {
                chromeOptions.addArguments(getProperties().getProperty("chrome.options").split(","));
                webDriver = new RemoteWebDriver(new URL(getProperties().getProperty("remote")), chromeOptions);
            } else {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
            driver.set(webDriver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
