package Lecture_13;

import BaseObjects.BaseTest;
import PageObject.herokuapp.HomeLinks;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Parameters({"linkName"})
    @Test
    public void homePage_Test(String linkName) {
        get(HomePage.class)
                .open();
        get(HomePage.class).verifyTitleTxt()
                .verifySubTitleTxt();

        get(HomePage.class).scrollDown();
        get(HomePage.class).clickLink(HomeLinks.valueOf(linkName));
    }
}
