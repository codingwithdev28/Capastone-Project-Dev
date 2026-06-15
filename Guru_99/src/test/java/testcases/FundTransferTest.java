package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FundTransferPage;
import pages.LoginPage;
import utilities.configReader;
import utilities.TestData;

public class FundTransferTest extends BaseTest {

    @Test(priority = 5,description = "VERIFY FUND TRANSFER")
    public void verifyFundTransfer() {

        if (TestData.accountId == null) {

            throw new RuntimeException("Account ID is null. Run AccountTest first.");
        }

        LoginPage lp = new LoginPage(driver);

        lp.login(configReader.getUsername(),configReader.getPassword());

        FundTransferPage fp =new FundTransferPage(driver);

        fp.transferFund(TestData.accountId,"184039","500","Fund Transfer");

        Assert.assertTrue(fp.verifyTransferSuccess(),"Fund Transfer Failed");

        System.out.println("Fund Transfer Successful");
    }
}