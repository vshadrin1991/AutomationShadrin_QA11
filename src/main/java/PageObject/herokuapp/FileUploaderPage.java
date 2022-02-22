package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploaderPage extends BasePage {
    private By uploadBtn = By.id("file-upload");
    private By title = By.tagName("h3");
    private By fileSubmit = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");
    private String userDir = System.getProperty("user.dir");
    private By dragDropUpload = By.id("drag-drop-upload");
    private By uploadFileName = By.xpath("//*[@id='drag-drop-upload']//*[@class='dz-filename']//span");

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    public FileUploaderPage verifyPageTitle(String title) {
        Assert.assertEquals(getText(this.title), title);
        return this;
    }

    public FileUploaderPage uploadFile() {
        driver.findElement(uploadBtn).sendKeys("E:\\QA11-onl\\AutomationShadrin_QA11\\files");
        return this;
    }

    public FileUploaderPage clickFileSubmit() {
        click(fileSubmit);
        return this;
    }

    public FileUploaderPage verifyThatFileUploaded(String name) {
        Assert.assertEquals(getText(uploadedFiles), name);
        return this;
    }

    public FileUploaderPage dragDropUpload(String imgName){
        click(dragDropUpload);
        pause(1);
        StringSelection stringSelection = new StringSelection(userDir + "\\files\\" + imgName);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getText(uploadFileName), imgName);
        return this;
    }


}
