package PageObject.rabotaby.SerachResultPage;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchRoot extends BasePage {
    private By reactRoot = By.id("HH-React-Root");
    private By searchResultCount = By.tagName("h1");

    public SearchRoot checkSearchResultPage() {
        isElementExist(reactRoot);
        return this;
    }

    public SearchRoot checkSearchResult(String searchText, Integer searchCount) {
        Assert.assertEquals(getText(searchResultCount), "" + searchCount + " вакансий «" + searchText + "»");
        return this;
    }
}
