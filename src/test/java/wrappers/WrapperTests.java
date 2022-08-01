package wrappers;


import BaseObjects.BaseTestModule;
import Driver.DriverModule;
import PageObject.google.GooglePage;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;


public class WrapperTests extends BaseTestModule {

    @Inject
    GooglePage googlePage;

    @Test
    public void test() {
        googlePage
                .goTo()
                .enterSearch("Hello world");
    }
}
