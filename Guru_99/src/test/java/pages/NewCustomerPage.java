package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCustomerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By newCustomerMenu =By.xpath("//a[text()='New Customer']");

    private By cName =By.name("name");

    private By gender =By.name("rad1");

    private By dob =By.name("dob");

    private By address =By.name("addr");

    private By city =By.name("city");

    private By state =By.name("state");

    private By pin =By.name("pinno");

    private By mobile =By.name("telephoneno");

    private By email =By.name("emailid");

    private By password =By.name("password");

    private By submit =By.name("sub");

    private By customerIdText =By.xpath("//td[text()='Customer ID']/following-sibling::td");

    public String addCustomer(String name,String birthDate,String addr,String cityName,String stateName,String pinCode,String mobileNo,String emailId,String pass) 
    {

        wait.until(ExpectedConditions.elementToBeClickable(newCustomerMenu)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(cName)).sendKeys(name);

        driver.findElement(gender).click();
        driver.findElement(dob).sendKeys(birthDate);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(pin).sendKeys(pinCode);
        driver.findElement(mobile).sendKeys(mobileNo);
        driver.findElement(email).sendKeys(emailId);
        driver.findElement(password).sendKeys(pass);

        driver.findElement(submit).click();

        WebElement customerIdElement =wait.until(ExpectedConditions.visibilityOfElementLocated(customerIdText));

        return customerIdElement.getText();
    }
}