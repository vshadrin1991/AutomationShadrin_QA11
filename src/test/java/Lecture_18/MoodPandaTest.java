package Lecture_18;

import BaseObjects.SelenideBaseTest;
import PageObject.moodpanda.HomePage;
import org.testng.annotations.Test;

public class MoodPandaTest extends SelenideBaseTest {

    @Test
    public void homePage_Test() {
        get(HomePage.class)
                .clickGetStarted()
                .enterUser("User")
                .enterPassword("Password")
                .clickLogin()
                .checkLoginException();
    }
}
