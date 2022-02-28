package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FramesPage extends BasePage {
    private By title = By.tagName("h3");
    private By iframeId = By.id("mce_0_ifr");
    private By iframeText = By.cssSelector("#tinymce > p");

    private By getFrameLink(String frame) {
        return By.linkText(frame);
    }

    public FramesPage verifyPageTitle(String title) {
        Assert.assertEquals(getText(this.title), title);
        return this;
    }

    public FramesPage clickFrameLink(String frameLink) {
        click(getFrameLink(frameLink));
        return this;
    }

    public FramesPage verifyFrameText(String expectedText) {
        driver.switchTo().frame(driver.findElement(iframeId));
        Assert.assertEquals(getText(iframeText), expectedText);
        return this;
    }


}
