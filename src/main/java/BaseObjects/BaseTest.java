package BaseObjects;

import Driver.DriverManager;
import TestNgUtills.InvokedMethodsListener;
import TestNgUtills.Listener;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.lang.reflect.InvocationTargetException;

import static Driver.DriverManagerFactory.getManager;

@Listeners({Listener.class, InvokedMethodsListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;
    protected DriverManager driverManager;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        this.driverManager = getManager(DriverManagerType.valueOf(context.getSuite().getParameter("browser").toUpperCase()));
        this.driver = DriverManager.getDriver();
    }

    protected <T> T get(Class<T> page) {
        T instance = null;
        try {
            instance = page.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @AfterTest
    public void postcondition() {
        DriverManager.closeDriver();
    }

}
