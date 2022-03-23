package RabotaBy;

import BaseObjects.BaseTest;
import PageObject.RabotaBy.HomePage.HomePage;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Parameters(value = "search")
    @Test(priority = 1)
    public void checkHomePage_Test(@Optional(value = "Test") String search) {
        get(HomePage.class)
                .open()
                .getMainElement()
                .checkElement()
                .getHeaderElement()
                .checkElement()
                .getFooterElement()
                .checkElement()
                .getDashboardElement()
                .checkElement()
                .getMainElement()
                .enterSearch(search);
    }
}
