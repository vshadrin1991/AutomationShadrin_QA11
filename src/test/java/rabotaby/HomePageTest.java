package rabotaby;

import BaseObjects.BaseTest;
import PageObject.rabotaby.ContentPage.HomePageContent.HomePage;
import PageObject.rabotaby.ContentPage.HomePageContent.MainElement;
import PageObject.rabotaby.ContentPage.SearchPageContent.SearchRoot;
import PageObject.rabotaby.FooterPage.FooterElement;
import PageObject.rabotaby.HeaderPage.HeaderElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Parameters("search")
    @Test(priority = 1)
    public void checkHomePage_Test(String search) {
        get(HomePage.class)
                .open()
                .getMainElement()
                .checkReactRoot()
                .getDashboardElement()
                .checkDashboardContent();

        get(HeaderElement.class).checkSupernovaOverlay();
        get(FooterElement.class).checkSupernovaFooter();

        get(HomePage.class)
                .getMainElement()
                .enterSearch(search);
    }

    @Parameters("search")
    @Test(priority = 2)
    public void checkSearchPage_Test(String search) {
        get(SearchRoot.class).checkSearchResultPage().checkSearchResult(search);
    }
}
