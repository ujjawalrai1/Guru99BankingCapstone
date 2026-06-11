package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.NewCustomerPage;
import utilities.ConfigReader;

public class CustomerTest extends BaseTest {

    public static String customerId;

    @Test(priority = 1)
    public void addCustomerTest() {

        ConfigReader config = new ConfigReader();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                config.getUsername(),
                config.getPassword());

        NewCustomerPage customerPage =
                new NewCustomerPage(driver);

        customerPage.clickNewCustomer();

        customerPage.addCustomer(
                "Ujjawal",
                "2000-01-01",
                "Noida Sector 74",
                "Noida",
                "UP",
                "201301",
                "9876543210",
                "ujjawal"
                        + System.currentTimeMillis()
                        + "@gmail.com",
                "pass123");

        customerId =
                customerPage.getCustomerId();

        // IMPORTANT
        ConfigReader.customerId =
                customerId;

        System.out.println(
                "Generated Customer ID : "
                        + customerId);

        Assert.assertFalse(
                customerId.isEmpty(),
                "Customer ID Not Generated");
    }

    @Test(priority = 2)
    public void validateCustomerIdTest() {

        Assert.assertNotNull(
                ConfigReader.customerId,
                "Customer ID not generated");

        Assert.assertFalse(
                ConfigReader.customerId.isEmpty(),
                "Customer ID is empty");
    }
}