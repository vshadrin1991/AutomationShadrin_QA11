package Lecture_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.CheckboxesPage;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    @Test(description = "Checkbox page", priority = 1)
    public void checkboxesAllChecked_Test() {
        get(CheckboxesPage.class)
                .verifyCheckboxStatus(2, true)
                .verifyCheckboxStatus(1, false);

        get(CheckboxesPage.class)
                .clickCheckbox(1);

        get(CheckboxesPage.class)
                .verifyCheckboxStatus(2, true)
                .verifyCheckboxStatus(1, true);
    }
}
