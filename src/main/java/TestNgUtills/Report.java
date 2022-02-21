package TestNgUtills;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Report implements ITestListener {

    // This belongs to ITestListener and will execute before the whole Test starts
    @Override
    public void onStart(ITestContext context) {
        Reporter.log("About to begin executing Class " + context.getName(), true);
    }

    // This belongs to ITestListener and will execute, once the whole Test is finished
    @Override
    public void onFinish(ITestContext context) {
        Reporter.log("About to end executing Class " + context.getName(), true);
    }

    // This belongs to ITestListener and will execute before each test method
    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Testcase " + result.getName() + " started successfully", true);
    }

    // This belongs to ITestListener and will execute only in the event of a successful test method
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Testcase " + result.getName() + " passed successfully", true);
    }

    // This belongs to ITestListener and will execute only in the event of a fail test
    public void onTestFailure(ITestResult result) {
        Reporter.log("Testcase " + result.getName() + " failed", true);
    }

    // This belongs to ITestListener and will execute only in the event of the skipped test method
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Testcase " + result.getName() + " got skipped", true);
    }
}
