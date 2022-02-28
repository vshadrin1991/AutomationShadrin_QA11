package Lecture_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {
    @BeforeClass
    public void preconditions() {
        get(HomePage.class)
                .open();
    }

    @Test
    public void verifyHomePageObject_Test() {
        get(HomePage.class).verifyTitleTxt()
                .verifySubTitleTxt();
    }
}
