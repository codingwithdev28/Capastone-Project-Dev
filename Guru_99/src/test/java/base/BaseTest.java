package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.configReader;

public class BaseTest {

    public static WebDriver driver;

    configReader cr = new configReader();

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(configReader.getUrl());
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}