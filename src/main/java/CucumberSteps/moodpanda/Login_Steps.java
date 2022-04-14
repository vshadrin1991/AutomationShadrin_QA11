package CucumberSteps.moodpanda;

import BaseObjects.SelenideBaseTest;
import PageObject.moodpanda.HomePage;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps extends SelenideBaseTest {

    @Given("i load page")
    public void openPage() {
        get(HomePage.class);
    }

    @When("i click get started")
    public void clickGetStarted() {
        get(HomePage.class).clickGetStarted();
    }

    @When("i enter user {string}")
    public void enterUser(String email) {
        get(HomePage.class).enterUser(email);
    }

    @When("i enter password {string}")
    public void enterPassword(String password) {
        get(HomePage.class).enterPassword(password);
    }

    @When("i click on login button")
    public void clickLogin() {
        get(HomePage.class).clickLogin();
    }

    @Then("check login exception")
    public void checkLoginException() {
        get(HomePage.class).checkLoginException();
    }

    @But("check login exception {string}")
    public void checkLoginException(String exception) {
        get(HomePage.class).checkLoginException(exception);
    }

    @Then("i close")
    public void close() {
        super.close();
    }
}
