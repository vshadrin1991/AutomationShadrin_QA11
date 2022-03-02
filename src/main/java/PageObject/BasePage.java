package PageObject;

import Configuration.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static BaseObjects.DriverCreation.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;
    protected Logger log = Logger.getLogger(BasePage.class);

    protected BasePage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.actions = new Actions(this.driver);
        this.properties = PropertyReader.getProperties();
    }

    public BasePage open() {
        String url = properties.getProperty("url");
        log.debug("Open page " + url);
        driver.get(url);
        return this;
    }

    protected BasePage open(String url) {
        log.debug("Open page " + url);
        driver.get(url);
        return this;
    }

    protected BasePage enter(By element, CharSequence... data) {
        log.debug("Enter " + data);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(data);
        return this;
    }

    protected BasePage click(By element) {
        log.debug("Click on " + element);
        driver.findElement(element).click();
        return this;
    }

    protected BasePage clickLink(String linkText) {
        log.debug("Click link " + linkText);
        driver.findElement(By.linkText(linkText)).click();
        return this;
    }

    public BasePage scrollDown() {
        log.debug("Scroll down");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
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

    protected void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
