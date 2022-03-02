package Lecture_13;

import BaseObjects.BaseTest;
import PageObject.herokuapp.FramesPage;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void iframe_Test() {
        get(FramesPage.class)
                .verifyTitle("Frames")
                .clickOnFrameLink("iFrame")
                .verifyTitle("An iFrame containing the TinyMCE WYSIWYG Editor")
                .switchToFrame()
                .enterTextArea("Hello world!")
                .unSwitchToFrame();
    }
}
