package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        BrowserOptions<FirefoxOptions> browserOptions = new BrowserOptions();
        WebDriver webDriver = new FirefoxDriver(browserOptions.getBrowserOptions(DriverManagerType.FIREFOX));
        driver.set(webDriver);
    }
}
