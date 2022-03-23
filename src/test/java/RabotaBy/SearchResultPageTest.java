package RabotaBy;

import BaseObjects.BaseTest;
import PageObject.RabotaBy.SerachResultPage.SearchRoot;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseTest {

    @Parameters(value = "search")
    @Test(priority = 1)
    public void checkSearchPage_Test(@Optional(value = "Test") String search) {
        get(SearchRoot.class).checkElement().checkSearchResult(search, 80);
    }
}
