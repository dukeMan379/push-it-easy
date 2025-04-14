package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import pageObjects.LoginPage;
import utilities.BaseClass;

import java.io.IOException;

public class Login {
    LoginPage loginPage;

    @Before
    public void setup() {

        loginPage = new LoginPage(BaseClass.getDriver());

    }

    @When("User enters valid username")
    public void user_enters_valid_username() throws IOException {
        loginPage.enterValidUserName();

    }

    @When("User enters valid password")
    public void user_enters_valid_password() throws IOException {
        loginPage.enterValidPassword();
    }

    @When("User click on login button")
    public void user_click_on_login_button() {
        loginPage.clickOnLogin();

    }

    @Then("User successfully logged in")
    public void user_successfully_logged_in() {

        loginPage.userOnManagerPage();
    }

    @When("User enter {string}")
    public void user_enters_username(String userName) {

        loginPage.enterUserName(userName);
    }
    @And("User enters {string}")
    public void user_enters_password(String password) {

        loginPage.enterPassword(password);
    }

    @Then("User fails to log in")
    public void user_fails_to_log_in () {

        }
    }
