package Lecture_11;

import BaseObjects.BaseTest;
import PageObject.herokuapp.CheckboxesPage;
import PageObject.herokuapp.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static PageObject.herokuapp.HomeLinks.CHECKBOXES;

public class Lecture_11 extends BaseTest {

    String url;

    @BeforeTest
    public void getUrl() {
        url = context.getSuite().getParameter("url");
    }

    @BeforeClass
    public void preconditions() {
        get(HomePage.class)
                .open(url)
                .verifyTitleTxt()
                .verifySubTitleTxt();
        get(HomePage.class).clickLink(CHECKBOXES);
    }

    @Test(description = "Checkbox page", priority = 1)
    @Description("Verify Checkbox page")
    @Step("1. All checkbox checked")
    @Link("https://instagram.com/")
    @Issue("COVID-19")
    @TmsLink("COVID-19")
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


    @Test(description = "Checkbox page", priority = 2)
    @Description("Verify Checkbox page")
    @Step("2. All checkbox unchecked")
    @Link("https://instagram.com/")
    @Issue("COVID-19")
    @TmsLink("COVID-19")
    public void checkboxesAllUnchecked_Test() {
        get(CheckboxesPage.class)
                .clickCheckbox(1).clickCheckbox(2);

        get(CheckboxesPage.class)
                .verifyCheckboxStatus(2, false)
                .verifyCheckboxStatus(1, false);
    }


    @Test(description = "Checkbox page", priority = 3)
    @Description("Verify Checkbox page")
    @Step("3. All checkbox one checked")
    @Link("https://instagram.com/")
    @Issue("COVID-19")
    @TmsLink("COVID-19")
    public void checkboxesAllOneChecked_Test() {
        get(CheckboxesPage.class)
                .clickCheckbox(1);

        get(CheckboxesPage.class)
                .verifyCheckboxStatus(2, false)
                .verifyCheckboxStatus(1, true);
    }
}
