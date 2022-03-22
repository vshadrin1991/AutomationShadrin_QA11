package PageObject.rabotaby.homepage.elements;

import PageObject.rabotaby.homepage.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HeaderElement extends HomePage implements HomeInterface {
    private By supernovaOverlay = By.cssSelector("[class='supernova-overlay']");

    @Override
    public HomePage checkElement() {
        Assert.assertTrue(isElementExist(supernovaOverlay));
        return this;
    }
}
