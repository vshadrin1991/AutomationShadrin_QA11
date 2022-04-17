package TestNgUtills;

import Driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodsListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess() && DriverManager.getDriver() != null) {
            byte[] file = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            saveScreenshots(file);
        }
    }

    @Attachment(value = "Screenshots", type = "image/png")
    private byte[] saveScreenshots(byte[] bytes) {
        return bytes;
    }
}
