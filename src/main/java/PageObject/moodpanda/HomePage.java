package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    @FindBy(css = "[class ^= 'button is-white']")
    SelenideElement getStarted;

    SelenideElement title = $("[class ^= 'title']");

    @FindBy(className = "subtitle")
    SelenideElement subtitle;

    @FindBy(css = "[alt ='MoodPanda large logo']")
    SelenideElement img;

    @FindBy(css = "input[type = 'text']")
    SelenideElement user;

    @FindBy(css = "input[type = 'password']")
    SelenideElement password;

    public HomePage clickGetStarted() {
        getStarted.click();
        return this;
    }

    public HomePage checkSubTitleText() {
        subtitle.should(Condition.matchText("Track your mood / Build your mood diary / Receive support"));
        return this;
    }

    public HomePage checkTitleText() {
        title.should(Condition.text("MoodPanda"));
        return this;
    }

    public HomePage checkImage() {
        this.img.shouldBe(Condition.exist);
        return this;
    }

    public HomePage enterUser(String user){
        this.user.sendKeys(user);
        return this;
    }

    public HomePage enterPassword(String password){
        this.password.sendKeys(password);
        return this;
    }
}
