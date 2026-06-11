package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.NewAccountPage;
import utilities.ConfigReader;

public class AccountTest extends BaseTest {

    public static String accountId;

    @Test(priority = 1)
    public void createAccountTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                config.getUsername(),
                config.getPassword());

        NewAccountPage accountPage =
                new NewAccountPage(driver);

        accountPage.clickNewAccount();

        // Customer ID from CustomerTest
        String customerId = "29195";

        System.out.println("Customer ID = " + customerId);

        accountPage.createAccount(
                customerId,
                "5000");
        accountId =
                accountPage.getAccountId();

        // IMPORTANT
        ConfigReader.accountId =
                accountId;

        System.out.println(
                "Generated Account ID : "
                        + accountId);

        Assert.assertFalse(
                accountId.isEmpty(),
                "Account ID Not Generated");

        Assert.assertTrue(
                driver.getPageSource()
                        .contains(
                                "Account Generated Successfully"),
                "Account Creation Failed");
    }

    @Test(priority = 2)
    public void verifyAccountDetailsTest() {

        Assert.assertNotNull(
                ConfigReader.accountId,
                "Account ID not generated");

        Assert.assertFalse(
                ConfigReader.accountId.isEmpty(),
                "Account ID is empty");
    }
}