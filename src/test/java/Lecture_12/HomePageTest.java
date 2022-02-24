package Lecture_12;

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
                .open(context.getSuite().getParameter("url"))
                .verifyTitleTxt()
                .verifySubTitleTxt();
        get(HomePage.class).clickLink(HomeLinks.valueOf(linkName));
    }
}
