package base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver =new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {

        boolean isJenkins =System.getenv("JENKINS_HOME") != null;

        boolean isDocker =new File("/.dockerenv").exists();

        switch (browser.toLowerCase()) {

        case "chrome":

            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = getChromeOptions(isJenkins, isDocker);

            driver.set(new ChromeDriver(chromeOptions));

            break;

        case "edge":

            WebDriverManager.edgedriver().setup();

            EdgeOptions edgeOptions =new EdgeOptions();

            edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

            driver.set(new EdgeDriver(edgeOptions));

            break;

        default:

            throw new RuntimeException("Unsupported Browser : "+ browser);
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        return getDriver();
    }

    private static ChromeOptions getChromeOptions(boolean isJenkins,boolean isDocker) {

        ChromeOptions options =new ChromeOptions();

        options.setAcceptInsecureCerts(true);

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        options.addArguments("--remote-allow-origins=*");

        options.addArguments("--disable-blink-features=AutomationControlled");

        if (isJenkins || isDocker) {

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

        } else {

            options.addArguments("--start-maximized");
        }

        return options;
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}