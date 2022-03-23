package PageObject.RabotaBy.HomePage.Elements;

import PageObject.RabotaBy.ElementInterface;
import PageObject.RabotaBy.HomePage.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MainElement extends HomePage implements ElementInterface {
    private By reactRoot = By.id("HH-React-Root");
    private By searchInput = By.cssSelector("[data-qa='search-input']");
    private By submit = By.cssSelector("[class='supernova-search-submit-text']");

    @Override
    public HomePage checkElement() {
        Assert.assertTrue(isElementExist(reactRoot));
        return this;
    }

    public HomePage enterSearch(String searchText) {
        enter(searchInput, searchText);
        clickButton(submit);
        return this;
    }
}