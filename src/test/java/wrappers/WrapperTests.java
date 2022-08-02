package wrappers;


import Modules.BaseTestModule;
import PageObject.google.GooglePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class WrapperTests extends BaseTestModule {

    @Parameters("search")
    @Test
    public void test(String value) {
        get(GooglePage.class)
                .goTo()
                .enterSearch(value);
    }
}
