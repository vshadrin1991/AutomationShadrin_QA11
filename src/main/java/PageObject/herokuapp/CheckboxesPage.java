package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckboxesPage extends BasePage {

    private By checkboxes(Integer index) {
        return By.xpath("(//*[@id='checkboxes']//input)[" + index + "]");
    }

    public CheckboxesPage clickCheckbox(Integer index) {
        click(checkboxes(index));
        return this;
    }

    public CheckboxesPage verifyCheckboxStatus(Integer index, Boolean status) {
        if (status) {
            verifyThatCheckboxChecked(index);
        } else {
            verifyThatCheckboxUnchecked(index);
        }
        return this;
    }

    private CheckboxesPage verifyThatCheckboxChecked(Integer index) {
        Assert.assertEquals(getAttribute(checkboxes(index), "checked"), "true", "Checkbox is unchecked.");
        return this;
    }

    private CheckboxesPage verifyThatCheckboxUnchecked(Integer index) {
        Assert.assertNotEquals(getAttribute(checkboxes(index), "checked"), "true", "Checkbox is checked.");
        return this;
    }
}
