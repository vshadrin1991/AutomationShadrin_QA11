package Lecture_18;


import static com.codeborne.selenide.CollectionCondition.*;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Configuration.*;

public class Lecture_18 {

    @Test
    public void moodPandaHomePage_Test() {
        browserSize = "1000x1000";
        open("https://moodpanda.com/");
        $("[class ^= 'button is-white']").click();
        $("[type='text']").sendKeys("user");
        $("[type='password']").sendKeys("password");
        $("[class ^= 'button is-vcentered']").should(exist).click();
        $(byXpath("//*[contains(@class, 'is-danger is-small')]")).shouldHave(text("Invalid email address"));
        System.out.println($$("[class = 'button is-small is-fullwidth is-rounded is-light']").texts());
        $$("[class = 'button is-small is-fullwidth is-rounded is-light']").should(size(3));
    }
}
