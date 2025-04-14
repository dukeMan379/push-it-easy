package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.CommonUtility;

import java.io.IOException;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@name='uid']")
    WebElement userIDPath;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordPath;

    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement loginButtonPath;

    @FindBy(xpath = "//input[@name='btnReset']")
    WebElement resetButtonPath;

    public void enterValidUserName() throws IOException {
        String userName = CommonUtility.readPropertiesFile("userName");
        userIDPath.sendKeys(userName);
    }

    public void enterValidPassword() throws IOException {
        String password = CommonUtility.readPropertiesFile("password");
        passwordPath.sendKeys(password);
    }

    public void clickOnLogin(){
        loginButtonPath.click();
    }

    public void userOnManagerPage(){
        String managerPageURL = BaseClass.getDriver().getCurrentUrl();
        if(managerPageURL.equals("https://demo.guru99.com/V1/html/Managerhomepage.php")){
            System.out.println("User successfully logged in");
        } else{
            System.out.println("Login failed");
        }

        //Assert.assertEquals("https://demo.guru99.com/V1/html/Managerhomepage.php",managerPageURL);
    }

    public void enterUserName(String userName){
        userIDPath.sendKeys(userName);
    }

    public void enterPassword(String password){
        passwordPath.sendKeys(password);
    }

    public void userNotValid(){

        String alertText = BaseClass.getDriver().switchTo().alert().getText();

        if(alertText.equalsIgnoreCase("User is not valid")){
            System.out.println("Invalid userName");
        } else{
            System.out.println("Invalid users can also login");
        }

        BaseClass.getDriver().switchTo().alert().accept();
    }
}
