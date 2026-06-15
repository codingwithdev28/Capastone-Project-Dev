package pages;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.WebDriver;

public class FundTransferPage {

    WebDriver driver;
    WebDriverWait wait;

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By fundTransferMenu = By.xpath("//a[normalize-space()='Fund Transfer']");
    By payerAccount = By.name("payersaccount");
    By payeeAccount = By.name("payeeaccount");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    public void transferFund(String fromAccount,String toAccount,String transferAmount,String desc) {


    	try {wait.until(ExpectedConditions.elementToBeClickable(fundTransferMenu)).click();
    	
    	} catch (Exception e) {
    		
    	    driver.get("https://demo.guru99.com/V4/manager/FundTransInput.php");
    	}

        driver.findElement(payerAccount).sendKeys(fromAccount);

        driver.findElement(payeeAccount).sendKeys(toAccount);

        driver.findElement(amount).sendKeys(transferAmount);

        driver.findElement(description).sendKeys(desc);

        driver.findElement(submitBtn).click();
    }

    public boolean verifyTransferSuccess() {

        return driver.getPageSource().contains("Fund Transfer Details");
    }
}