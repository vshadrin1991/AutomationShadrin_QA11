package TestNgUtills;

import org.testng.ITestContext;
import org.testng.ITestListener;

import static BaseObjects.DriverCreation.createDriver;

public class Listener implements ITestListener {
    private static String browserName;
    private static ITestContext context;

    @Override
    public void onStart(ITestContext context) {
        this.context = context;
        this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
        createDriver(browserName == null ? "chrome" : browserName);
    }

    public static ITestContext getContext() {
        return context;
    }
}
