package BaseObjects;

import TestNgUtills.ExtentReport;
import TestNgUtills.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.lang.reflect.InvocationTargetException;

import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;

@Listeners({Listener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;
    private String browserName;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
        this.driver = getDriver();
    }

    protected <T> T get(Class<T> page) {
        return get(page, this.driver);
    }

    protected <T> T get(Class<T> page, WebDriver driver) {
        T instance = null;
        try {
            instance = page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @AfterTest
    public void postcondition() {
        closeDriver(browserName == null ? "chrome" : browserName);
    }

}
