package Driver;

import PropertiesHelper.PropertyReader;
import TestNgUtills.Listener;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Driver.DriverManager.getDriver;
import static PropertiesHelper.PropertyReader.getProperties;

public class DriverModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PropertyReader.class).toInstance(new PropertyReader("google"));
        bind(DriverManagerFactory.class).toInstance(new DriverManagerFactory(DriverManagerType.CHROME));
        Names.bindProperties(binder(), getProperties());
    }

    @Provides
    public WebDriver getDrivers() {
        DriverManagerFactory.getManager();
        return getDriver();
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

}
