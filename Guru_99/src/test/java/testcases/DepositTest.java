package testcases;


import org.testng.annotations.Test;

import base.BaseTest;
import pages.DepositPage;
import pages.LoginPage;
import utilities.configReader;
import utilities.TestData;

public class DepositTest extends BaseTest {

    @Test(priority = 4,description = "VERIFY DEPOSIT")
    public void verifyDeposit() {

        if (TestData.accountId == null) {

            throw new RuntimeException("Account ID is null. Run AccountTest first.");
        }

        LoginPage lp = new LoginPage(driver);

        lp.login(configReader.getUsername(),configReader.getPassword());

        DepositPage dp =new DepositPage(driver);

        dp.depositAmount(TestData.accountId,"1000","Cash Deposit");

        System.out.println("Deposit Successful for Account : "+ TestData.accountId);
    }
}