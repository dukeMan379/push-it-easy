package utilities;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

public class CommonUtility extends BaseClass{
    public CommonUtility() throws IOException {
    }

    public static void screenshot(String fileName) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

        File screenshotFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\conne\\IdeaProjects\\CucumberBDDFramework\\" +
                "src\\test\\screenshots"+fileName+timeStamp+".png"));
    }

    public static String readPropertiesFile(String property) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Duke\\IdeaProjects\\CucumberBDDFramework\\" +
                "src\\test\\java\\config\\env.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String myProperty = prop.getProperty(property);
        return myProperty;
    }

    public static void elementToBeClickable(WebDriver driver, int waitTime, WebElement element){
        WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

}
