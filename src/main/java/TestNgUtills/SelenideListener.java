package TestNgUtills;

import BaseObjects.SelenideConfigurations;
import Properties.PropertyReader;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SelenideListener implements ITestListener {
    SelenideConfigurations selenideConfigurations;

    @Override
    public void onStart(ITestContext context) {
        selenideConfigurations = new SelenideConfigurations(new PropertyReader(context.getSuite().getParameter("config")));
        System.setProperty("logger_time", getSimpleDate());
    }

    private String getSimpleDate() {
        return new SimpleDateFormat("yyyyMMdd-HHmmss").format(Calendar.getInstance().getTime());
    }
}
