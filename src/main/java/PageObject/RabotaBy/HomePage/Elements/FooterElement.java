package PageObject.RabotaBy.HomePage.Elements;

import PageObject.RabotaBy.ElementInterface;
import PageObject.RabotaBy.HomePage.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FooterElement extends HomePage implements ElementInterface {
    private By supernovaFooter = By.cssSelector("[class='supernova-footer HH-Supernova-Footer']");

    @Override
    public HomePage checkElement() {
        Assert.assertTrue(isElementExist(supernovaFooter));
        return this;
    }
}
