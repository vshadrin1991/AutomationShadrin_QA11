package Lecture_13;

import BaseObjects.BaseTest;
import PageObject.herokuapp.JavaScriptAlertsPage;
import org.testng.annotations.Test;

import static PageObject.herokuapp.JavaScriptAlertsPage.Button.ALERT;

public class JavaScriptAlertsTest extends BaseTest {

    @Test
    public void alert_Test() {
        get(JavaScriptAlertsPage.class)
                .verifyTitle()
                .clickOnButton(ALERT)
                .checkAlertText("I am a JS Alert")
                .closeAlert();
    }
}
