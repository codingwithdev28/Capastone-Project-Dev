package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitForVisibility(WebDriver driver,WebElement element,int seconds) 
    {

        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(seconds));

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(WebDriver driver,WebElement element,int seconds) 
    {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}