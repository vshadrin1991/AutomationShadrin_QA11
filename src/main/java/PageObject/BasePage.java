package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Reporter.*;

public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected BasePage open(String url) {
        log("Open page " + url);
        driver.get(url);
        return this;
    }

    protected BasePage enter(By element, CharSequence... data) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(data);
        return this;
    }

    protected BasePage click(By element) {
        log("Click on " + element);
        driver.findElement(element).click();
        return this;
    }

    protected Integer findElementsCount(By element) {
        return driver.findElements(element).size();
    }

    protected String getText(By element) {
        return driver.findElement(element).getText();
    }

    /**
     * @param element       - web element
     * @param attributeName - attribute name
     * @return String of element attribute name
     */
    protected String getAttribute(By element, String attributeName) {
        return driver.findElement(element).getAttribute(attributeName);
    }

}
