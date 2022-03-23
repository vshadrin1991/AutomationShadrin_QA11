package PageObject.RabotaBy.SerachResultPage;

import PageObject.BasePage;
import PageObject.RabotaBy.ElementInterface;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchRoot extends BasePage implements ElementInterface {
    private By reactRoot = By.id("HH-React-Root");
    private By searchResultCount = By.tagName("h1");

    @Override
    public SearchRoot checkElement() {
        isElementExist(reactRoot);
        return this;
    }

    public SearchRoot checkSearchResult(String searchText, Integer searchCount) {
        Assert.assertEquals(getText(searchResultCount), "" + searchCount + " вакансий «" + searchText + "»");
        return this;
    }
}
