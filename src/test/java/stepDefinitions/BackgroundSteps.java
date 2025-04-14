package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.LoginPage;
import pageObjects.NewCustomerPage;
import utilities.BaseClass;
import utilities.CommonUtility;

import java.io.IOException;

public class BackgroundSteps {
    LoginPage loginPage;
    NewCustomerPage newCustomerPage;

    @Before(order=2)
    public void setup(){
        loginPage = new LoginPage(BaseClass.getDriver());
        newCustomerPage = new NewCustomerPage(BaseClass.getDriver());
    }


    @Given("User on the Guru99 Banking Page")
    public void user_on_the_guru99_banking_page() throws IOException {

        String myURL = CommonUtility.readPropertiesFile("url");
        BaseClass.getDriver().get(myURL);
    }



    @And("user log in with valid username and password and navigates to New Customer Page")
    public void user_log_in_with_valid_username_and_password_and_navigates_to_new_customer_page() throws IOException {

        loginPage.enterValidUserName();
        loginPage.enterValidPassword();
        loginPage.clickOnLogin();
        newCustomerPage.clickOnNewCustomerModule();
    }
}
