package TestNgUtills

import geb.Browser
import io.qameta.allure.Attachment
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.reporters.ExitCodeListener

class TestListener extends ExitCodeListener {
    @Override
    void onTestFailure(ITestResult result) {
        super.onTestFailure(result)
        tackeScreenshot()
    }

    @Override
    void onTestSkipped(ITestResult result) {
        super.onTestSkipped(result);
    }

    @Override
    void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result)
        tackeScreenshot()
    }

    @Override
    void onStart(ITestContext context) {
        super.onStart(context)
    }

    @Override
    void onFinish(ITestContext context) {
        super.onFinish(context)
    }

    @Override
    void onTestStart(ITestResult result) {
        super.onTestStart(result)
        tackeScreenshot()
    }

    @Attachment("screenshot")
    static byte[] tackeScreenshot() {
        return ((TakesScreenshot) new Browser().getDriver()).getScreenshotAs(OutputType.BYTES)
    }
}
