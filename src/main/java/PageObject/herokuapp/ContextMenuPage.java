package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static PageObject.herokuapp.HomeLinks.CONTEXT_MENU;

public class ContextMenuPage extends BasePage {
    private By title = By.tagName("h3");
    private By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public ContextMenuPage verifyPageTitle() {
        Assert.assertEquals(getText(title), CONTEXT_MENU.getLink());
        return this;
    }

    public ContextMenuPage verifyAlertText() {
        actions.contextClick(driver.findElement(hotSpot)).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        return this;
    }
}
