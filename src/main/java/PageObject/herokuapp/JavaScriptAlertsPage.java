package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePage {
    private By jsAlertBtn = By.cssSelector("[onclick*='jsAlert']");
    private By jsConfirmBtn = By.cssSelector("[onclick*='jsConfirm']");
    private By jsPromptBtn = By.cssSelector("[onclick*='jsPrompt']");
    private By title = By.tagName("h3");


    public JavaScriptAlertsPage verifyTitle() {
        Assert.assertEquals(getText(title), "JavaScript Alerts");
        return this;
    }

    public enum Button {ALERT, CONFIRM, PROMPT}

    public JavaScriptAlertsPage clickOnButton(Button button) {
        By jsButton = null;
        switch (button) {
            case ALERT:
                jsButton = jsAlertBtn;
                break;
            case PROMPT:
                jsButton = jsConfirmBtn;
                break;
            case CONFIRM:
                jsButton = jsPromptBtn;
                break;
        }
        clickButton(jsButton);
        return this;
    }

    public JavaScriptAlertsPage checkAlertText(String expectedText) {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedText);
        return this;
    }

    public JavaScriptAlertsPage closeAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

}
