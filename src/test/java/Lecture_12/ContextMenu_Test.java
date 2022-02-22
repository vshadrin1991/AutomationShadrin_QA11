package Lecture_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.ContextMenuPage;
import PageObject.herokuapp.HomeLinks;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.Test;

public class ContextMenu_Test extends BaseTest {

    @Test
    public void contextMenu_Test() {
        get(HomePage.class).clickLink(HomeLinks.CONTEXT_MENU);
        get(ContextMenuPage.class)
                .verifyPageTitle()
                .verifyAlertText();
    }
}
