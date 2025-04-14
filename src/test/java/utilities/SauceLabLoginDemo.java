package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class SauceLabLoginDemo {

    public static WebDriver driver;

    @Test(priority = 0)
    public void initializeDriver(){
        System.setProperty("webdriver.edge.driver", "E:\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(priority = 1, dataProvider = "Login Data from Excel", dataProviderClass = ExcelDataReader.class)
    public void login(String userName, String password) throws InterruptedException {

        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.id("user-name")).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
    }
}
