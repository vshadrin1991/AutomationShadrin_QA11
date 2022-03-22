package rabotaby;

import BaseObjects.BaseTest;
import PageObject.rabotaby.SerachResultPage.SearchRoot;
import PageObject.rabotaby.homepage.*;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void checkHomePage_Test() {
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
                .enterSearch("Automation QA");
    }

    @Test(priority = 2)
    public void checkSearchPage_Test() {
        get(SearchRoot.class).checkSearchResultPage().checkSearchResult("Automation QA", 76);
    }
}
