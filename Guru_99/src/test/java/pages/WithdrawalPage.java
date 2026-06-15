package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawalPage {

    WebDriver driver;

    public WithdrawalPage(WebDriver driver) {
        this.driver = driver;
    }

    By withdrawalMenu = By.xpath("//a[normalize-space()='Withdrawal']");
    By accountNo = By.name("accountno");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    public void withdrawAmount(String accNo,String withdrawAmt,String desc) {

        driver.findElement(withdrawalMenu).click();

        driver.findElement(accountNo).sendKeys(accNo);

        driver.findElement(amount).sendKeys(withdrawAmt);

        driver.findElement(description).sendKeys(desc);

        driver.findElement(submitBtn).click();
    }
}