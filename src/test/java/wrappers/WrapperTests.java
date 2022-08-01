package wrappers;


import Driver.DriverModule;
import PageObject.google.GooglePage;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = {DriverModule.class})
public class WrapperTests {

    @Inject
    GooglePage googlePage;

    @Test
    public void test() {
        googlePage
                .goTo()
                .enterSearch("Hello world");
    }
}
