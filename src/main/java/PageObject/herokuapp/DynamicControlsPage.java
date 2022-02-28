package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlsPage extends BasePage {
    private By removeBtn = By.cssSelector("#checkbox-example>button");
    private By textBack = By.cssSelector("#checkbox-example>p");
    private By title = By.tagName("h4");

    public DynamicControlsPage verifyPageTitle() {
        Assert.assertEquals(getText(title), HomeLinks.DYNAMIC_CONTROLS.getLink());
        return this;
    }

    public DynamicControlsPage clickRemoveBtn() {
        click(removeBtn);
        return this;
    }

    public DynamicControlsPage verifyElementText(String text) {
        wait.until(ExpectedConditions.textToBe(textBack, text));
        return this;
    }

}
