package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FramesPage extends BasePage {

    private By title = By.tagName("h3");
    private By frame = By.id("mce_0_ifr");
    private By textArea = By.id("tinymce");

    public FramesPage verifyTitle(String titleText) {
        Assert.assertEquals(getText(title), titleText);
        return this;
    }

    public FramesPage clickOnFrameLink(String text) {
        clickLink(text);
        return this;
    }

    public FramesPage switchToFrame() {
        driver.switchTo().frame(driver.findElement(frame));
        return this;
    }

    public FramesPage enterTextArea(String enterText) {
        enter(textArea, enterText);
        return this;
    }

    public FramesPage unSwitchToFrame() {
        driver.switchTo().defaultContent();
        return this;
    }
}
