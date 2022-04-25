package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Log4j
public class HomePage {

    @FindBy(how = How.CSS, using = "[class ^= 'button is-white']")
    SelenideElement getStarted;

    @FindBy(css = "[type='text']")
    SelenideElement email;

    SelenideElement password = $("[type='password']");
    SelenideElement login = $("[class ^= 'button is-vcentered']");
    SelenideElement emailException = $(byXpath("//*[contains(@class, 'is-danger is-small')]"));

    public HomePage clickGetStarted() {
        log.debug("Click get started");
        getStarted.click();
        return this;
    }

    public HomePage enterUser(String email) {
        log.debug("Enter user");
        this.email.sendKeys(email);
        return this;
    }

    public HomePage enterPassword(String password) {
        log.debug("Enter password");
        this.password.sendKeys(password);
        return this;
    }

    public HomePage clickLogin() {
        login.click();
        return this;
    }

    public HomePage checkLoginException() {
        emailException.shouldHave(Condition.text("email address"));
        return this;
    }
    public HomePage checkLoginException(String exception) {
        emailException.shouldHave(Condition.text(exception));
        return this;
    }

}
