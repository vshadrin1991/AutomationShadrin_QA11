package TestNgUtills;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static BaseObjects.DriverCreation.getDriver;

public class InvokedMethodsListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess() && getDriver() != null) {
            byte[] file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            saveScreenshots(file);
        }
    }

    @Attachment(value = "Screenshots", type = "image/png")
    private byte[] saveScreenshots(byte[] bytes) {
        return bytes;
    }
}
