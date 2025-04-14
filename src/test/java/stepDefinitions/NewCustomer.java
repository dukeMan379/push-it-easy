package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.NewCustomerPage;
import utilities.BaseClass;

import java.io.IOException;

public class NewCustomer {

    NewCustomerPage newCustomerPage;

    @Before(order=3)
    public void setup(){
        newCustomerPage = new NewCustomerPage(BaseClass.getDriver());
    }

    @When("user does not enter a value in NAME Field")
    public void user_does_not_enter_a_value_in_name_field() {
        newCustomerPage.clickOnNameField();
    }

    @And("user press TAB and move to next Field")
    public void user_press_tab_and_move_to_next_field() {
        newCustomerPage.pressTAB();
    }

    @Then("An error message Customer name must not be blank must appear")
    public void an_error_message_customer_name_must_not_be_blank_must_appear() throws IOException {
        newCustomerPage.validateNameIsBlankErrorText();
    }

    @When("user enters numeric {string} in NAME Field")
    public void user_enters_numeric_in_name_field(String string) {

    }

    @Then("An error message Numbers are not allowed must appear")
    public void an_error_message_numbers_are_not_allowed_must_appear() {

    }

    @When("user enters special {string} in NAME Field")
    public void user_enters_special_in_name_field(String string) {

    }

    @Then("An error message Special characters are not allowed must appear")
    public void an_error_message_special_characters_are_not_allowed_must_appear() {

    }

    @When("user enters first character Blank Space in NAME Field")
    public void user_enters_first_character_blank_space_in_name_field() {

    }

    @Then("An error message First characters cannot be space must appear beside Name field")
    public void an_error_message_first_characters_cannot_be_space_must_appear_beside_name_field() {

    }

    @When("user does not enter a value in ADDRESS Field")
    public void user_does_not_enter_a_value_in_address_field() {

    }

    @Then("An error message Address can not be empty must appear")
    public void an_error_message_address_can_not_be_empty_must_appear() {

    }

    @When("user enters first character Blank Space in ADDRESS Field")
    public void user_enters_first_character_blank_space_in_address_field() {

    }

    @Then("An error message First characters cannot be space must appear beside Address field")
    public void an_error_message_first_characters_cannot_be_space_must_appear_beside_address_field() {

    }

    @When("user does not enter a value in CITY Field")
    public void user_does_not_enter_a_value_in_city_field() {

    }

    @Then("An error message City must not be blank must appear")
    public void an_error_message_city_must_not_be_blank_must_appear() {

    }

    @When("user enters numeric {string} in CITY Field")
    public void user_enters_numeric_in_city_field(String string) {

    }

    @Then("An error message Numbers are not allowed must appear beside City field")
    public void an_error_message_numbers_are_not_allowed_must_appear_beside_city_field() {

    }

    @When("user enters special {string} in CITY Field")
    public void user_enters_special_in_city_field(String string) {

    }

    @Then("An error message Special characters are not allowed must appear for City Field")
    public void an_error_message_special_characters_are_not_allowed_must_appear_for_city_field() {

    }

    @When("user enters first character Blank Space in CITY Field")
    public void user_enters_first_character_blank_space_in_city_field() {

    }

    @Then("An error message First characters cannot be space must appear beside City field")
    public void an_error_message_first_characters_cannot_be_space_must_appear_beside_city_field() {

    }
}
