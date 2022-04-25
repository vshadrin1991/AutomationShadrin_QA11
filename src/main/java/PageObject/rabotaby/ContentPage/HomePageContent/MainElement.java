package PageObject.rabotaby.ContentPage.HomePageContent;

import org.openqa.selenium.By;
import org.testng.Assert;

public class MainElement extends HomePage {
    private By reactRoot = By.id("HH-React-Root");
    private By searchInput = By.cssSelector("[data-qa='search-input']");
    private By submit = By.cssSelector("[class='supernova-search-submit-text']");

    public HomePage checkReactRoot() {
        Assert.assertTrue(isElementExist(reactRoot));
        return this;
    }

    public MainElement enterSearch(String searchText) {
        enter(searchInput, searchText);
        clickButton(submit);
        return this;
    }
}
