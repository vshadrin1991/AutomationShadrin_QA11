package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Arrays;

public class HomePage extends BasePage {
    private By title = By.tagName("h1");
    private By subTitle = By.tagName("h2");

    private By getLink(String text) {
        return By.partialLinkText(text);
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

    public HomePage verifyHomePage() {
        Arrays.asList(HomeLinks.values()).forEach(homePageLinksEnum -> Assert.assertTrue(driver.findElement(getLink(homePageLinksEnum.getLink())).isDisplayed()));
        return this;
    }

    public HomePage clickLink(HomeLinks link) {
        actions.click(driver.findElement(getLink(link.getLink()))).perform();
        return this;
    }
}
