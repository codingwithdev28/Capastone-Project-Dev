package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.configReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        LoginPage lp = new LoginPage(driver);

        lp.login(configReader.getUsername(),configReader.getPassword());

        HomePage hp = new HomePage(driver);

        Assert.assertTrue(hp.verifyLogin());
    }
}