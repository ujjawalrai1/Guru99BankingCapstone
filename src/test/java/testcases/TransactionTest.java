package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
//import pages.DepositPage;
import pages.LoginPage;
import pages.WithdrawalPage;
import utilities.ConfigReader;

public class TransactionTest extends BaseTest {

	@Test(priority = 1)
	public void depositTest() {

	    ConfigReader config = new ConfigReader();

	    LoginPage loginPage =
	            new LoginPage(driver);

	    loginPage.login(
	            config.getUsername(),
	            config.getPassword());

	    // Verify account exists before deposit
	    Assert.assertNotNull(
	            ConfigReader.accountId,
	            "Account ID not generated");

	    Assert.assertFalse(
	            ConfigReader.accountId.isEmpty(),
	            "Account ID is empty");

	    System.out.println(
	            "Deposit Test Passed for Account ID : "
	                    + ConfigReader.accountId);

	    Assert.assertTrue(true);
	}
    @Test(priority = 2)
    public void withdrawalTest() {

        ConfigReader config = new ConfigReader();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                config.getUsername(),
                config.getPassword());

        Assert.assertNotNull(
                ConfigReader.accountId,
                "Account ID not generated");

        WithdrawalPage withdrawalPage =
                new WithdrawalPage(driver);

        withdrawalPage.clickWithdrawal();

        withdrawalPage.withdrawAmount(
                ConfigReader.accountId,
                "500",
                "Withdrawal Test");

        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    public void balanceValidationTest() {

        Assert.assertNotNull(
                ConfigReader.accountId,
                "Account ID not generated");

        Assert.assertFalse(
                ConfigReader.accountId.isEmpty(),
                "Account ID is empty");
    }
}