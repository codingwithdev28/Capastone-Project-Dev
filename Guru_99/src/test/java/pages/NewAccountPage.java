package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {

    WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By newAccountMenu = By.xpath("//a[normalize-space()='New Account']");
    By cId = By.name("cusid");
    By accountType = By.name("selaccount");
    By initialDeposit = By.name("inideposit");
    By submit = By.name("button2");

    public String createAccount(
            String custId,
            String deposit) {

        driver.findElement(newAccountMenu).click();

        driver.findElement(cId).sendKeys(custId);

        Select accType =new Select(driver.findElement(accountType));

        accType.selectByVisibleText("Savings");

        driver.findElement(initialDeposit).sendKeys(deposit);

        driver.findElement(submit).click();

        return driver.findElement(By.xpath("//td[contains(text(),'Account ID')]/following-sibling::td")).getText();
    }
}