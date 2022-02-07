package BaseObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverCreation {
    private static WebDriver driver = null;

    public enum Drivers {IE, CHROME, FIREFOX};

    public static WebDriver getDriver(Drivers drivers) {

        if (driver == null) {
            switch(drivers) {
                case IE:
                    driver = new InternetExplorerDriver();
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.close();
        driver.quit();
    }
}
