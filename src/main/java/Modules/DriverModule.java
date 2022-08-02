package Modules;

import Driver.DriverManagerFactory;
import PropertiesHelper.PropertyReader;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import java.time.Duration;

import static Driver.DriverManager.getDriver;
import static PropertiesHelper.PropertyReader.getProperties;

public class DriverModule implements Module {
    @Override
    public void configure(Binder binder) {
        ITestContext context = ParentModule.getContext();
        binder.bind(PropertyReader.class).toInstance(new PropertyReader((context.getSuite().getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config"))));
        Names.bindProperties(binder, getProperties());
    }

    @Provides
    public WebDriver getDrivers() {
        DriverManagerFactory.getManager(DriverManagerType.valueOf(getProperties().getProperty("browser")));
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
