package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class HomePage {

    SelenideElement getStarted = $("[class ^= 'button is-white']");
    SelenideElement email = $("[type='text']");
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
