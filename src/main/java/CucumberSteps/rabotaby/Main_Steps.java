package CucumberSteps.rabotaby;

import BaseObjects.BaseTest;
import PageObject.rabotaby.ContentPage.HomePageContent.MainElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Main_Steps extends BaseTest {


    @Given("i open page")
    public void openPage() {
        get(MainElement.class).open();
    }

    @Then("i check root")
    public void checkRoot() {
        get(MainElement.class).checkReactRoot();
    }
}
