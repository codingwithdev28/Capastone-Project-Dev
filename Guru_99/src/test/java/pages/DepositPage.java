package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage {

    WebDriver driver;

    public DepositPage(WebDriver driver) {
        this.driver = driver;
    }

    By depositMenu = By.xpath("//a[normalize-space()='Deposit']");
    By accountNo = By.name("accountno");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submit = By.name("AccSubmit");

    public void depositAmount(String accNo,String amt,String desc) {

        driver.findElement(depositMenu).click();

        driver.findElement(accountNo).sendKeys(accNo);

        driver.findElement(amount).sendKeys(amt);

        driver.findElement(description).sendKeys(desc);

        driver.findElement(submit).click();
    }
}