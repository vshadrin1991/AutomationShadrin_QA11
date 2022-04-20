package TestNgUtills;

import Properties.PropertyReader;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

import static io.github.bonigarcia.wdm.WebDriverManager.getInstance;
import static Driver.DriverManager.getDriver;
public class Listener implements ITestListener {
    private static ITestContext context;
    private static Properties properties;

    @Override
    public void onStart(ITestContext context) {
        System.setProperty("logger_time", getSimpleDate());
        new PropertyReader(context.getSuite().getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config"));
        this.properties = PropertyReader.getProperties();

    }

    private String getSimpleDate() {
        return new SimpleDateFormat("yyyyMMdd-HHmmss").format(Calendar.getInstance().getTime());
    }
}
