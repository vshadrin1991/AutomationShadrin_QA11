package TestNgUtills;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Hello i am started !!!");
    }
}
