package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.WithdrawalPage;
import utilities.configReader;
import utilities.TestData;

public class WithdrawalTest extends BaseTest {

    @Test(priority = 6,description = "VERIFY WITHDRAWAL")
    public void verifyWithdrawal() {

        if (TestData.accountId == null) {

            throw new RuntimeException("Account ID is null. Run AccountTest first.");
        }

        LoginPage lp = new LoginPage(driver);

        lp.login(configReader.getUsername(),configReader.getPassword());

        WithdrawalPage wp =new WithdrawalPage(driver);

        wp.withdrawAmount(TestData.accountId,"500","ATM Withdrawal");

        System.out.println("Withdrawal Successful for Account : "+ TestData.accountId);
    }
}