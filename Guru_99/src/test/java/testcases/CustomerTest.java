package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.NewCustomerPage;
import utilities.configReader;
import utilities.ExcelUtils;
import utilities.TestData;

public class CustomerTest extends BaseTest {

    @Test(priority = 2,description = "CREATE CUSTOMER")
    public void AddNewCustomer() {

        LoginPage lp = new LoginPage(driver);

        lp.login(configReader.getUsername(),configReader.getPassword());

      

        NewCustomerPage cp =new NewCustomerPage(driver);

        String customerName ="Chirantan Dev";

        String dob ="01082003";

        String address ="DDA Flats";

        String city ="Dwarka";

        String state ="Delhi";

        String pin ="110059";

        String mobile ="9876543210";

        String uniqueEmail ="Dev"+ System.currentTimeMillis()+ "@guru99.com";

        String customerPassword ="Dev@123";

        String customerId =cp.addCustomer(customerName,dob,address,city,state,pin,mobile,uniqueEmail,customerPassword);

        Assert.assertNotNull(customerId,"Customer ID was not generated");

        Assert.assertFalse(customerId.isEmpty(),"Customer ID is empty");

        TestData.customerId = customerId;

        ExcelUtils.writeData("src/test/resources/TestData.xlsx",
                customerName,
                dob,
                address,
                city,
                state,
                pin,
                mobile,
                uniqueEmail,
                customerPassword,
                "",
                ""
        );

        System.out.println("Customer Created Successfully");

        System.out.println("Customer ID : "+ customerId);
    }
}