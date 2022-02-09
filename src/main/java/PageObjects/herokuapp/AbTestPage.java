package PageObjects.herokuapp;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbTestPage extends BasePage {

    private By title = By.tagName("h3");
    private By text = By.tagName("p");

    public AbTestPage(WebDriver driver) {
        super.driver = driver;
    }

    public AbTestPage checkTitle() {
        Assert.assertEquals(driver.findElement(title).getText(), "A/B Test Variation 1");
        return this;
    }

    public AbTestPage checkText() {
        Assert.assertEquals(driver.findElement(text).getText(), "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).");
        return this;
    }
}
