package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class HomePage {

    @FindBy(how = How.CSS, using = "[class ^= 'button is-white']")
    SelenideElement getStarted;

    @FindBy(css = "[type='text']")
    SelenideElement email;

    SelenideElement password = $("[type='password']");
    SelenideElement login = $("[class ^= 'button is-vcentered']");
    SelenideElement emailException = $(byXpath("//*[contains(@class, 'is-danger is-small')]"));

    public HomePage clickGetStarted() {
        getStarted.click();
        return this;
    }

    public HomePage enterUser(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public HomePage enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public HomePage clickLogin() {
        login.click();
        return this;
    }

    public HomePage checkLoginException() {
        emailException.shouldHave(Condition.text("Invalid  email address"));
        return this;
    }
}
