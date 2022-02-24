package BaseObjects;

import TestNgUtills.InvokedMethodsListener;
import TestNgUtills.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.lang.reflect.InvocationTargetException;

import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;

@Listeners({Listener.class, InvokedMethodsListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        this.driver = getDriver();
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
        closeDriver();
    }

}
