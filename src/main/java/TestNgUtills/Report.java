package TestNgUtills;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Report implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("\nI am started with " + result.getName(), true);
    }

    @Override
    public void onFinish(ITestContext context) {
        Reporter.log("\nI am finished with " + context.getName(), true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("\nI am failed on " + result.getName(), true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("\nI am passed on " + result.getName(), true);
    }
}
