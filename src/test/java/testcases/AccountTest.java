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

        // Use valid customer id
        String customerId = "29195";

        System.out.println(
                "Customer ID = " + customerId);

        accountPage.createAccount(
                customerId,
                "5000");

        accountId =
                accountPage.getAccountId();

        System.out.println(
                "Generated Account ID = "
                        + accountId);

        // Store globally for TransactionTest
        ConfigReader.accountId =
                accountId;

        Assert.assertNotNull(
                accountId,
                "Account ID is null");

        Assert.assertFalse(
                accountId.trim().isEmpty(),
                "Account ID is empty");
    }

    @Test(priority = 2)
    public void verifyAccountDetailsTest() {

        System.out.println(
                "Stored Account ID = "
                        + ConfigReader.accountId);

        Assert.assertNotNull(
                ConfigReader.accountId,
                "Account ID not generated");

        Assert.assertFalse(
                ConfigReader.accountId.trim().isEmpty(),
                "Account ID is empty");
    }
}