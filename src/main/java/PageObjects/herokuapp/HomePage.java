package PageObjects.herokuapp;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {
    private By mainHeader = By.tagName("h1");
    private By header = By.tagName("h2");

    private By getLinks(String name) {
        return By.partialLinkText(name);
    }

    public HomePage(WebDriver driver) {
        super.driver = driver;
    }

    public HomePage checkMainHeader() {
        Assert.assertEquals(driver.findElement(mainHeader).getText(), "Welcome to the-internet");
        return this;
    }

    public HomePage checkHeader() {
        Assert.assertEquals(driver.findElement(header).getText(), "Available Examples");
        return this;
    }

    public HomePage clickLink(String name) {
        driver.findElement(getLinks(name)).click();
        return this;
    }
}
