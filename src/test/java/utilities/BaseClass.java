package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    private static WebDriver driver;


    public BaseClass() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Duke\\IdeaProjects\\CucumberBDDFramework\\src\\test\\java\\config\\env.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String myURL = prop.getProperty("url");
        String myBrowser = prop.getProperty("browser");
        if (myBrowser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--guest"});
            driver = new ChromeDriver(options);
        } else if (myBrowser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments(new String[]{"--guest"});
            driver = new EdgeDriver();
        } else if (myBrowser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(new String[]{"--guest"});
            driver = new FirefoxDriver(options);
        } else if (myBrowser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver() throws IOException {
        new BaseClass();
    }
}
