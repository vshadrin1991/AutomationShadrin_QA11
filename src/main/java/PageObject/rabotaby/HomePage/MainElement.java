package PageObject.rabotaby.HomePage;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MainElement extends BasePage {
    private By reactRoot = By.id("HH-React-Root");
    private By searchInput = By.cssSelector("[data-qa='search-input']");
    private By submit = By.cssSelector("[class='supernova-search-submit-text']");

    public MainElement open(){
        super.open();
        return this;
    }

    public MainElement checkReactRoot() {
        Assert.assertTrue(isElementExist(reactRoot));
        return this;
    }

    public MainElement enterSearch(String searchText) {
        enter(searchInput, searchText);
        clickButton(submit);
        return this;
    }
}
