package Driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class DriverManager {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    {
        if (driver.get() == null) {
            try {
                createDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void createDriver() throws MalformedURLException;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}
