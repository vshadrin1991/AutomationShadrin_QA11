package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver = null;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected BasePage open(String url) {
        driver.get(url);
        return this;
    }

    protected BasePage open() {
        driver.get("");
        return this;
    }

    protected BasePage enter(By element, CharSequence... data) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(data);
        return this;
    }

    protected BasePage click(By element, Boolean test) {
        driver.findElement(element).click();
        return this;
    }

    protected BasePage click(By element) {
        driver.findElement(element).click();
        return this;
    }

    protected Integer findElementsCount(By element) {
        return driver.findElements(element).size();
    }

    protected String getText(By element) {
        return driver.findElement(element).getText();
    }

}
