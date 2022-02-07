package BaseObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverCreation {
    private static WebDriver driver = null;

    public enum Drivers {IE, CHROME, FIREFOX};

    public static WebDriver getDriver(Drivers drivers) {
        WebDriverManager.getInstance(drivers.name()).setup();
        if (driver == null) {
            switch(drivers) {
                case IE:
                    driver = new InternetExplorerDriver();
                    break;
                case CHROME:
                    //WebDriverManager.chromedriver().setup();
                    //driver = new ChromeDriver();
                    driver = WebDriverManager.getInstance(drivers.name()).create();
                    break;
                case FIREFOX:
                    //driver = WebDriverManager.getInstance(drivers.name()).getWebDriver();
                    driver = WebDriverManager.getInstance(drivers.name()).create();
                    break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(Drivers drivers){
        //driver.close();
        //driver.quit();
        WebDriverManager.getInstance(drivers.name()).quit();
    }
}
