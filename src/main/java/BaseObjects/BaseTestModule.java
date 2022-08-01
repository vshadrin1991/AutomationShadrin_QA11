package BaseObjects;

import Driver.DriverModule;
import TestNgUtills.InvokedMethodsListener;
import TestNgUtills.Listener;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;

import static Driver.DriverManager.closeDriver;

@Listeners({Listener.class, InvokedMethodsListener.class})
@Guice(modules = {DriverModule.class})
public class BaseTestModule {
    protected ITestContext context;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
    }

    @AfterTest(alwaysRun = true)
    public void postcondition() {
        closeDriver();
    }

}
