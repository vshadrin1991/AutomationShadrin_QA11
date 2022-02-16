package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.herokuapp.AbtestPage;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {

    @BeforeTest
    public void preconditions() {
        get(HomePage.class).open(context.getSuite().getParameter("url"));
    }

    @Test
    public void test() {
        get(HomePage.class)
                .verifyTitleTxt()
                .verifySubTitleTxt()
                .clickLink("A/B Testing");

        get(AbtestPage.class)
                .checkTitleTxt()
                .checkContentTxt("Also known as split testing.");
    }

}
