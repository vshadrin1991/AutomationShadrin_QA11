package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static Properties.PropertyReader.getProperties;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(getProperties().getProperty("chrome.options").split(","));
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        driver.set(webDriver);
    }
}
