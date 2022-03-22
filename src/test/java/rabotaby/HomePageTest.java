package rabotaby;

import BaseObjects.BaseTest;
import PageObject.rabotaby.HomePage.DashboardElement;
import PageObject.rabotaby.HomePage.FooterElement;
import PageObject.rabotaby.HomePage.HeaderElement;
import PageObject.rabotaby.HomePage.MainElement;
import PageObject.rabotaby.SerachResultPage.SearchRoot;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void checkHomePage_Test() {
        get(MainElement.class).open().checkReactRoot();
        get(HeaderElement.class).checkSupernovaOverlay();
        get(FooterElement.class).checkSupernovaFooter();
        get(DashboardElement.class).checkDashboardContent();
        get(MainElement.class).enterSearch("Automation QA");
    }

    @Test(priority = 2)
    public void checkSearchPage_Test() {
        get(SearchRoot.class).checkSearchResultPage().checkSearchResult("Automation QA", 76);
    }
}
