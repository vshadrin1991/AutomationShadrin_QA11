package PageObject;


import Configs.ReadProperties;
import TestNgUtills.Listener;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
    protected Logger log;


    protected BasePage() {
        this.log = Logger.getLogger(BasePage.class);
        this.driver = getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.actions = new Actions(this.driver);
        this.properties = new ReadProperties(Listener.getContext().getSuite().getParameter("property")).getProperties();
    }

    public BasePage open() {
        log.debug("Open page " + properties.getProperty("url"));
        driver.get(properties.getProperty("url"));
        return this;
    }

    protected BasePage open(String url) {
        log.info("Open page " + url);
        driver.get(url);
        return this;
    }

    protected BasePage enter(By element, CharSequence... data) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(data);
        return this;
    }

    protected BasePage click(By element) {
        log.info("Click on " + element);
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

    protected void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
