package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static PageObject.herokuapp.Conditions.CONTAINS;
import static PageObject.herokuapp.Conditions.EQUAL;

public class AbtestPage extends BasePage {
    private By title = By.tagName("h3");
    private By content = By.tagName("p");

    public AbtestPage checkTitleTxt(Conditions conditions, String expectedTest) {
        switch (conditions) {
            case CONTAINS:
                Assert.assertTrue(getText(title).contains(expectedTest));
                break;
            case EQUAL:
                Assert.assertEquals(getText(title), expectedTest);
                break;
        }
        return this;
    }

    public AbtestPage checkContentTxt(Conditions conditions, String content) {
        if (conditions == EQUAL) {
            wait.until(ExpectedConditions.textToBe(this.content, content));
            Assert.assertEquals(getText(this.content), content);
        } else if (conditions == CONTAINS) {
            Assert.assertTrue(getText(this.content).contains(content));
        }
        return this;
    }


}
