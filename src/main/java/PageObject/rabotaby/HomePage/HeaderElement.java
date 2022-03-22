package PageObject.rabotaby.HomePage;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HeaderElement extends BasePage {
    private By supernovaOverlay = By.cssSelector("[class='supernova-overlay']");

    public HeaderElement checkSupernovaOverlay() {
        Assert.assertTrue(isElementExist(supernovaOverlay));
        return this;
    }
}
