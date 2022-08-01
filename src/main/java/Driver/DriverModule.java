package Driver;

import PropertiesHelper.PropertyReader;
import com.google.inject.AbstractModule;
import com.google.inject.Exposed;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.time.Duration;

public class DriverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DriverManagerFactory.class);
        PropertyReader propertyReader = new PropertyReader("google");
        Names.bindProperties(binder(), propertyReader.getProperties());
    }

    @Provides
    public WebDriver getDriver(DriverManagerFactory driverManagerFactory) {
        return driverManagerFactory.getManager(DriverManagerType.CHROME).getDriver();
    }

    @Provides
    public Actions getActions(WebDriver driver) {
        return new Actions(driver);
    }

    @Provides
    public WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Provides
    public JavascriptExecutor getExecutor(WebDriver driver) {
        return (JavascriptExecutor) (driver);
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver(DriverManagerFactory driverManagerFactory) {
        driverManagerFactory.getManager(DriverManagerType.CHROME).closeDriver();
    }
}
