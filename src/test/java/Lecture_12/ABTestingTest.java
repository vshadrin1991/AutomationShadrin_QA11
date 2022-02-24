package Lecture_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.AbtestPage;
import org.testng.annotations.Test;

import static PageObject.herokuapp.Conditions.CONTAINS;
import static PageObject.herokuapp.Conditions.EQUAL;

public class ABTestingTest extends BaseTest {

    @Test
    public void abTesting_Test() {
        get(AbtestPage.class)
                .checkTitleTxt(CONTAINS, "A/B Test")
                .checkContentTxt(EQUAL, "Also known as split testing.1");
    }

}
