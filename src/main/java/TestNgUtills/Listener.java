package TestNgUtills;

import Properties.PropertyReader;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        PropertyReader propertyReader  = new PropertyReader(context);
        System.setProperty("logger_time", new SimpleDateFormat("yyyyMMdd-HHmmss").format(Calendar.getInstance().getTime()));
    }
}
