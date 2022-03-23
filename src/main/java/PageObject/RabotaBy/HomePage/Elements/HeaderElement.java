package PageObject.RabotaBy.HomePage.Elements;

import PageObject.RabotaBy.ElementInterface;
import PageObject.RabotaBy.HomePage.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HeaderElement extends HomePage implements ElementInterface {
    private By supernovaOverlay = By.cssSelector("[class='supernova-overlay']");

    @Override
    public HomePage checkElement() {
        Assert.assertTrue(isElementExist(supernovaOverlay));
        return this;
    }
}
