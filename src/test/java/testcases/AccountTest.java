package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.NewAccountPage;
import utilities.ConfigReader;

public class AccountTest extends BaseTest {

    String accountId;

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

        ConfigReader.accountId =
                accountId;

        Assert.assertNotNull(
                accountId,
                "Account ID is null");

        Assert.assertFalse(
                accountId.isEmpty(),
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
                ConfigReader.accountId.isEmpty(),
                "Account ID is empty");
    }
}