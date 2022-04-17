package PageObject;

import Driver.DriverManager;
import Properties.PropertyReader;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Log4j
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
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
        log.debug("Enter " + Arrays.toString(data));
        findElement(element).clear();
        findElement(element).sendKeys(data);
        return this;
    }


    protected BasePage enter(By element, Boolean autoClean, CharSequence... data) {
        log.debug("Enter " + Arrays.toString(data));
        if (autoClean) {
            enter(element, data);
        } else {
            findElement(element).sendKeys(data);
        }
        return this;
    }

    private BasePage click(By element) {
        findElement(element).click();
        return this;
    }

    protected BasePage clickButton(By element) {
        log.debug("Click on button " + element);
        click(element);
        return this;
    }

    protected BasePage clickButton(WebElement element) {
        log.debug("Click on button " + element);
        element.click();
        return this;
    }

    protected BasePage clickCheckbox(By element) {
        log.debug("Click on checkbox " + element);
        click(element);
        return this;
    }

    protected BasePage clickTab(By element) {
        log.debug("Click on tab " + element);
        click(element);
        return this;
    }

    protected BasePage submit(By element) {
        log.debug("Submit " + element);
        findElement(element).submit();
        return this;
    }

    protected BasePage selectByValue(By element, String value) {
        log.debug("Select by value " + value);
        Select select = new Select(findElement(element));
        select.selectByValue(value);
        return this;
    }

    protected BasePage selectByIndex(By element, Integer index) {
        log.debug("Select by index " + index);
        Select select = new Select(findElement(element));
        select.selectByIndex(index);
        return this;
    }

    protected BasePage clickButtonRepeat(By element) {
        try {
            clickButton(element);
        } catch (ElementNotVisibleException e) {
            clickButton(element);
        }
        return this;
    }

    protected BasePage clickLink(String linkText) {
        log.debug("Click link " + linkText);
        findElement(By.linkText(linkText)).click();
        return this;
    }

    protected BasePage screenshot(String path) {
        log.debug("Take screenshot");
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File file = (File) takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(path));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return this;
    }

    protected BasePage alertAccept() {
        log.debug("Alert accept");
        driver.switchTo().alert().accept();
        return this;
    }

    protected BasePage alertDismiss() {
        log.debug("Alert accept");
        driver.switchTo().alert().dismiss();
        return this;
    }

    protected String getAlertText() {
        log.debug("Alert get text");
        return driver.switchTo().alert().getText();
    }

    protected BasePage alertAccept(String keysToSend) {
        log.debug("Alert send keys");
        driver.switchTo().alert().sendKeys(keysToSend);
        return this;
    }

    public BasePage scrollDown() {
        log.debug("Scroll down");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        return this;
    }

    public Boolean isElementExist(By element) {
        log.debug("Is element exist " + element);
        List<WebElement> elementList = findElements(element);
        return elementList.size() > 0;
    }

    public Boolean isElementDisplayed(By element) {
        log.debug("Is element displayed " + element);
        return findElement(element).isDisplayed();
    }

    public Boolean isElementEnabled(By element) {
        log.debug("Is element enabled " + element);
        return findElement(element).isEnabled();
    }

    protected Integer findElementsCount(By element) {
        log.debug("Find elements count " + element);
        return findElements(element).size();
    }

    protected String getText(By element) {
        log.debug("Get element text " + element);
        return findElement(element).getText();
    }

    protected WebElement findElement(By element) {
        log.debug("Find element :: " + element);
        return driver.findElement(element);
    }

    protected List<WebElement> findElements(By element) {
        log.debug("Find elements :: " + element);
        return driver.findElements(element);
    }

    protected BasePage verify(ExpectedCondition<Boolean> condition) {
        wait.ignoring(ElementNotVisibleException.class).until(condition);
        return this;
    }

    /**
     * @param element       - web element
     * @param attributeName - attribute name
     * @return String of element attribute name
     */
    protected String getAttribute(By element, String attributeName) {
        log.debug("get element attribute " + attributeName);
        return findElement(element).getAttribute(attributeName);
    }

    protected void sleep(long seconds) {
        log.debug("sleep timeout  " + seconds * 1000);
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
