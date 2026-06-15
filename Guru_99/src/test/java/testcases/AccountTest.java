package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.NewAccountPage;
import utilities.configReader;
import utilities.TestData;

public class AccountTest extends BaseTest {

    @Test(priority = 3,description = "CREATE ACCOUNT")
    public void createNewAccount() {

        if (TestData.customerId == null) {

            throw new RuntimeException("Customer ID not found. Run CustomerTest first.");
        }

        LoginPage lp = new LoginPage(driver);

        lp.login(configReader.getUsername(),configReader.getPassword());

        NewAccountPage ap =new NewAccountPage(driver);

        String accountId =ap.createAccount(TestData.customerId,"5000");

        Assert.assertNotNull(accountId);

        TestData.accountId = accountId;

        System.out.println("Account ID = "+ TestData.accountId);
    }
}