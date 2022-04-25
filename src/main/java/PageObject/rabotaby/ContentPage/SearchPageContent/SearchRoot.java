package PageObject.rabotaby.ContentPage.SearchPageContent;

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

    public SearchRoot checkSearchResult(String searchText) {
        Assert.assertTrue(Integer.parseInt(getText(searchResultCount).split(" ")[0]) > 0);
        Assert.assertTrue(getText(searchResultCount).contains(searchText));
        return this;
    }
}
