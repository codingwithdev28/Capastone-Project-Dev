package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By managerId = By.xpath("//td[normalize-space()='Manger Id : mngr662890']");

    public boolean verifyLogin() {
        return driver.findElement(managerId).isDisplayed();
    }
}