package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        WebDriver driver = DriverFactory.getDriver();

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String screenshotDir =System.getProperty("user.dir")+ "/screenshots/";

        File folder = new File(screenshotDir);

        if (!folder.exists()) 
        {
            folder.mkdirs();
        }

        String screenshotPath =screenshotDir+ testName+ "_"+ timestamp+ ".png";

        try {

            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            File destination = new File(screenshotPath);

            FileUtils.copyFile(source, destination);

        } catch (IOException e) {

            System.out.println("Failed to capture screenshot : " + e.getMessage());
        }

        return screenshotPath;
    }
}