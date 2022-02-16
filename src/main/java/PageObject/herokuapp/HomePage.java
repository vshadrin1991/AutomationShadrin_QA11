package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {
    private By title = By.tagName("h1");
    private By subTitle = By.tagName("h2");

    private By getLink(String text) {
        return By.partialLinkText(text);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String url) {
        super.open(url);
        return this;
    }

    public HomePage verifyTitleTxt() {
        Assert.assertEquals(getText(title), "Welcome to the-internet");
        return this;
    }

    public HomePage verifySubTitleTxt() {
        Assert.assertEquals(getText(subTitle), "Available Examples");
        return this;
    }

    public HomePage clickLink(String text) {
        click(getLink(text));
        return this;
    }
}
