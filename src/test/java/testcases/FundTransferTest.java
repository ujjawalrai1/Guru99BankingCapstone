package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FundTransferPage;
import pages.LoginPage;
import utilities.ConfigReader;

public class FundTransferTest extends BaseTest {

    @Test(priority = 1)
    public void fundTransferTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                config.getUsername(),
                config.getPassword());

        driver.get(
                "https://demo.guru99.com/V4/manager/FundTransInput.php");

        FundTransferPage transferPage =
                new FundTransferPage(driver);

        transferPage.transferFund(
                "184021",
                "184022",
                "100",
                "Fund Transfer Test");

        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void invalidAccountTransferTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                config.getUsername(),
                config.getPassword());

        driver.get(
                "https://demo.guru99.com/V4/manager/FundTransInput.php");

        FundTransferPage transferPage =
                new FundTransferPage(driver);

        transferPage.transferFund(
                "184021",
                "999999",
                "100",
                "Invalid Account");

        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    public void insufficientBalanceTransferTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                config.getUsername(),
                config.getPassword());

        driver.get(
                "https://demo.guru99.com/V4/manager/FundTransInput.php");

        FundTransferPage transferPage =
                new FundTransferPage(driver);

        transferPage.transferFund(
                "184021",
                "184022",
                "999999",
                "Insufficient Balance");

        Assert.assertTrue(true);
    }
}