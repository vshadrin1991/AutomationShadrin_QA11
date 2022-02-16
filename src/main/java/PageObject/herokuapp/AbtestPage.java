package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbtestPage extends BasePage {
    private By title = By.tagName("h3");
    private By content = By.tagName("p");


    public AbtestPage(WebDriver driver) {
        super(driver);
    }

    public AbtestPage checkTitleTxt() {
        Assert.assertEquals(getText(title), "A/B Test Variation 1");
        return this;
    }

    public AbtestPage checkContentTxt(String content) {
        Assert.assertTrue(getText(this.content).contains(content));
        return this;
    }
}
