package TestNgUtills;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static BaseObjects.DriverCreation.createDriver;
import static BaseObjects.DriverCreation.getDriver;

public class Listener implements ITestListener {
    private String browserName;

    @Override
    public void onStart(ITestContext context) {
        this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
        createDriver(browserName == null ? "chrome" : browserName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        byte[] file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshots(file);
    }

    @Attachment(value = "Screenshots", type = "image/png")
    private byte[] saveScreenshots(byte[] s) {
        return s;
    }
}
