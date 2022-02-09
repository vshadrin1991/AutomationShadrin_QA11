package Lecture_9;

import BaseObjects.BaseTest;
import PageObjects.herokuapp.AbTestPage;
import PageObjects.herokuapp.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {


    @BeforeTest
    public void preconditions() {
        driver.get(context.getSuite().getParameter("url"));
    }

    @Test
    public void abTesting_Test() {
        get(HomePage.class)
                .checkHeader()
                .checkMainHeader()
                .clickLink("A/B Testing");

        get(AbTestPage.class)
                .checkTitle().checkText();
    }
}
