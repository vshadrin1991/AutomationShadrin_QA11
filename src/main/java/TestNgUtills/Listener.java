package TestNgUtills;

import org.testng.ITestContext;
import org.testng.ITestListener;

import static BaseObjects.DriverCreation.createDriver;

public class Listener implements ITestListener {
    private String browserName;

    @Override
    public void onStart(ITestContext context) {
        this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
        createDriver(browserName == null ? "chrome" : browserName);
    }
}
