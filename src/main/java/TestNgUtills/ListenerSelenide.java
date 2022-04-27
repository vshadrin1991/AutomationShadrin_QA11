package TestNgUtills;

import Properties.PropertyReader;
import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static Properties.PropertyReader.getProperties;

public class ListenerSelenide implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.setProperty("logger_time", new SimpleDateFormat("yyyyMMdd-HHmmss").format(Calendar.getInstance().getTime()));
        new PropertyReader(context);
        setSelenideConfigurations();
    }

    public void setSelenideConfigurations() {
        Configuration.baseUrl = getProperties().getProperty("baseUrl") == null ? System.getProperty("baseUrl") : getProperties().getProperty("baseUrl");
        Configuration.browser = getProperties().containsKey("browser") ? getProperties().getProperty("browser") : Configuration.browser;
        Configuration.browserSize = getProperties().containsKey("browserSize") ? getProperties().getProperty("browserSize") : Configuration.browserSize;
        Configuration.headless = getProperties().containsKey("headless") ? Boolean.parseBoolean(getProperties().getProperty("headless")) : Configuration.headless;
    }
}
