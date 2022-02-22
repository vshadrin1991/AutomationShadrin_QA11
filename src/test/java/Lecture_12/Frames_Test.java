package Lecture_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.FramesPage;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.Test;

import static PageObject.herokuapp.HomeLinks.FRAMES;

public class Frames_Test extends BaseTest {

    @Test
    public void frames_Test() {
        get(HomePage.class).clickLink(FRAMES);
        get(FramesPage.class)
                .verifyPageTitle("Frames")
                .clickFrameLink("iFrame")
                .verifyPageTitle("An iFrame containing the TinyMCE WYSIWYG Editor")
                .verifyFrameText("Your content goes here.");
    }
}


