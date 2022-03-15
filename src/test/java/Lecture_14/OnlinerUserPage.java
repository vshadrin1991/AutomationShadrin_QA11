package Lecture_14;

import PageObject.BasePage;
import org.openqa.selenium.By;

public class OnlinerUserPage extends BasePage {

    private By email = By.cssSelector("[type='email']");
    private By password = By.xpath("//*[@autocomplete='password']//input");
    private By repeatPassword = By.xpath("//*[@autocomplete='repeatPassword']//input");


    public OnlinerUserPage auth(String email, String password) {
        enter(this.email, email);
        enter(this.password, password);
        return this;
    }


    public OnlinerUserPage auth(OnlinerUser user) {
        enter(this.email, user.email);
        enter(this.password, user.password);
        return this;
    }

    public OnlinerUserPage register(String email, String password, String repeatPassword) {
        enter(this.email, email);
        enter(this.password, password);
        enter(this.repeatPassword, repeatPassword);
        return this;
    }

    public OnlinerUserPage register(OnlinerUser user) {
        enter(this.email, user.email);
        enter(this.password, user.password);
        enter(this.repeatPassword, user.repeatPassword);
        return this;
    }

}
