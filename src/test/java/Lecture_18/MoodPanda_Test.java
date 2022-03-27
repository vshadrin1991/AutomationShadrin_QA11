package Lecture_18;

import BaseObjects.BaseTestSelenide;
import PageObject.moodpanda.HomePage;
import org.testng.annotations.Test;

public class MoodPanda_Test extends BaseTestSelenide {

    @Test
    public void verifyHomePage_Test() {
        get(HomePage.class)
                .checkTitleText()
                .checkSubTitleText()
                .checkImage();

        get(HomePage.class)
                .clickGetStarted()
                .enterUser("User")
                .enterPassword("Password");
    }
}
