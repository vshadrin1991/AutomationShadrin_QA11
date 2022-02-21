package TestNgUtills;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport implements ITestListener {
    static ExtentReports report;
    static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        report = new ExtentReports(System.getProperty("user.dir") + "/target/" + context.getName() + ".html");
        test = report.startTest(context.getName(), context.getCurrentXmlTest().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(LogStatus.FAIL,  result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP,  result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        report.endTest(test);
        report.flush();
    }
}
