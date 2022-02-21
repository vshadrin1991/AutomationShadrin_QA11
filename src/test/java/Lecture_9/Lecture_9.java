package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.herokuapp.AbtestPage;
import PageObject.herokuapp.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {

    @BeforeTest
    public void preconditions() {
        get(HomePage.class).open(context.getSuite().getParameter("url"));
    }

    @Test(description = "Human-readable test name")
    @Description("Some detailed test description")
    @Step("Searching for '{keyword}' in Google")
    @Link("https://instagram.com/dmitryrak11")
    @Issue("COVID-19")
    @TmsLink("COVID-19")
    @Attachment(value = "screenshot", type = "image/png")
    public void test() {
        get(HomePage.class)
                .verifyTitleTxt()
                .verifySubTitleTxt()
                .clickLink("A/B Testing");

        get(AbtestPage.class)
                .checkTitleTxt()
                .checkContentTxt("Also known as split testing.1");
    }

}
