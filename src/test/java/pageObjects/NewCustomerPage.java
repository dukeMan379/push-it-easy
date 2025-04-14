package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BaseClass;
import utilities.CommonUtility;

import java.io.IOException;

public class NewCustomerPage {
    public NewCustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    String errorOnSpecialChar = "Special characters are not allowed";
    String errorOnNumericChar = "Numbers are not allowed";
    String errorOnFirstCharBlank = "First characters cannot be space";
    String expectedNameFieldErrorText = "Customer name must not be blank";
    String expectedAddressFieldErrorText = "Address Field must be not blank";
    String expectedCityFieldErrorText = "City Field must be not blank";
    @FindBy(xpath = "//input[@name='name']")
    WebElement nameField;
    @FindBy(xpath = "//textarea[@name='addr']")
    WebElement addressField;
    @FindBy(xpath = "//input[@name='city']")
    WebElement cityField;
    @FindBy(xpath = "//label[@id='message']")
    WebElement nameFieldError;
    @FindBy(xpath = "//label[@id='message3']")
    WebElement addressFieldError;
    @FindBy(xpath = "//label[@id='message4']")
    WebElement cityFieldError;
    @FindBy(xpath = "//a[@href='addcustomerpage.php']")
    WebElement newCustomerModule;

    public void clickOnNewCustomerModule(){
        newCustomerModule.click();
    }

    public void clickOnNameField(){
        nameField.click();
    }

    public void pressTAB(){
        new Actions(BaseClass.getDriver()).sendKeys(Keys.TAB).perform();
    }

    public void validateNameIsBlankErrorText() throws IOException {
        if(!nameFieldError.isDisplayed()){
            System.out.println("Name Field Error Text is not displayed");
        }

        try{
            Assert.assertEquals(expectedNameFieldErrorText,nameFieldError.getText());
        } catch(AssertionError e){
            CommonUtility.screenshot("Name Is Blank");
            throw e;
        }


    }
}
