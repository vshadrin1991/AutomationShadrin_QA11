package Lecture_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.DynamicControlsPage;
import PageObject.herokuapp.HomeLinks;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.Test;

public class DynamicControls_Test extends BaseTest {

    @Test
    public void dynamicControls_Test() {
        get(HomePage.class).clickLink(HomeLinks.DYNAMIC_CONTROLS);
        get(DynamicControlsPage.class)
                .verifyPageTitle().clickRemoveBtn().verifyElementText("It's gone!");
    }

}
