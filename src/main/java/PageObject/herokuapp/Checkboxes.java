package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Checkboxes extends BasePage {

    private By checkboxes(Integer index) {
        return By.xpath("(//*[@id='checkboxes']//input)[" + index + "]");
    }

    public Checkboxes(WebDriver driver) {
        super(driver);
    }

    public Checkboxes clickCheckbox(Integer index) {
        click(checkboxes(index));
        return this;
    }

    public Checkboxes verifyCheckboxStatus(Integer index, Boolean status) {
        if (status) {
            verifyThatCheckboxChecked(index);
        } else {
            verifyThatCheckboxUnchecked(index);
        }
        return this;
    }

    private Checkboxes verifyThatCheckboxChecked(Integer index) {
        Assert.assertEquals(getAttribute(checkboxes(index), "checked"), "true");
        return this;
    }

    private Checkboxes verifyThatCheckboxUnchecked(Integer index) {
        Assert.assertNotEquals(getAttribute(checkboxes(index), "checked"), "true");
        return this;
    }
}
