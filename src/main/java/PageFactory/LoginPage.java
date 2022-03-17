package PageFactory;

import Entity.User;
import PageObject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@id='login-button']")
    WebElement loginBtn;

    @FindBy(css = "[data-test='error']")
    WebElement errorMessage;

    public LoginPage() {
        PageFactory.initElements(super.driver, this);
    }

    public LoginPage open() {
        super.open();
        return this;
    }

    public LoginPage enterUserName(String userName) {
        this.userName.sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        clickButton(loginBtn);
        return this;
    }

    public LoginPage login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginBtn();
        return this;
    }

    public LoginPage login(User user) {
        enterUserName(user.getUserName());
        enterPassword(user.getPassword());
        clickLoginBtn();
        return this;
    }

    public String getExceptionTxt() {
        return errorMessage.getText();
    }
}
