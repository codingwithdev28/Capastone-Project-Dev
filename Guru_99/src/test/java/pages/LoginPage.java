package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userid = By.name("uid");
    By password = By.name("password");
    By loginBtn = By.name("btnLogin");
    

    public void enterUsername(String user) {
        driver.findElement(userid).sendKeys(user);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pwd) {

 
        enterUsername(user);
        enterPassword(pwd);
        clickLogin();
    }
}