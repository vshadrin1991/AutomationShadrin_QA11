package PageObject.rabotaby.FooterPage;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FooterElement extends BasePage {
    private By supernovaFooter = By.cssSelector("[class $='Supernova-Footer']");

    public FooterElement checkSupernovaFooter() {
        Assert.assertTrue(isElementExist(supernovaFooter));
        return this;
    }
}
