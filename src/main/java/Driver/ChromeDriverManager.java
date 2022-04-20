package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        BrowserOptions<ChromeOptions> browserOptions = new BrowserOptions();
        WebDriver webDriver = new ChromeDriver(browserOptions.getBrowserOptions(DriverManagerType.FIREFOX));
        driver.set(webDriver);
    }
}
