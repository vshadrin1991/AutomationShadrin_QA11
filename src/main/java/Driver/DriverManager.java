package Driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class DriverManager {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    {
        if (driver.get() == null) {
            createDriver();
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public abstract void createDriver();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.remove();
        }
    }
}
