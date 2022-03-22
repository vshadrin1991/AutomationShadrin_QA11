package PageObject.rabotaby.homepage.elements;

import PageObject.rabotaby.homepage.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FooterElement extends HomePage implements HomeInterface {
    private By supernovaFooter = By.cssSelector("[class='supernova-footer HH-Supernova-Footer']");

    @Override
    public HomePage checkElement() {
        Assert.assertTrue(isElementExist(supernovaFooter));
        return this;
    }
}
