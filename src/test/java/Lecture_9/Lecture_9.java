package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.herokuapp.AbtestPage;
import PageObject.herokuapp.Checkboxes;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static PageObject.herokuapp.Conditions.CONTAINS;
import static PageObject.herokuapp.HomeLinks.AB_TESTING;
import static PageObject.herokuapp.HomeLinks.CHECKBOXES;

public class Lecture_9 extends BaseTest {
    String url;

    @BeforeClass
    public void getUrl() {
        url = context.getSuite().getParameter("url");
    }

    @BeforeMethod
    public void preconditions() {
        get(HomePage.class)
                .open(url)
                .verifyTitleTxt()
                .verifySubTitleTxt();
    }

    @Test
    public void abTesting_Test() {
        get(HomePage.class).clickLink(AB_TESTING);

        get(AbtestPage.class)
                .checkTitleTxt(CONTAINS, "A/B Test")
                .checkContentTxt(CONTAINS, "Also known as split testing.");
    }

    @Test
    public void checkboxes_Test() {
        get(HomePage.class).clickLink(CHECKBOXES);

        get(Checkboxes.class)
                .verifyCheckboxStatus(2, true)
                .verifyCheckboxStatus(1, false);

        get(Checkboxes.class)
                .clickCheckbox(1)
                .clickCheckbox(2);

        get(Checkboxes.class)
                .verifyCheckboxStatus(1, true)
                .verifyCheckboxStatus(2, true);
    }
}
