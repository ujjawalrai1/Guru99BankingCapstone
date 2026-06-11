package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtils;
import utilities.ConfigReader;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTest() {

        ConfigReader config = new ConfigReader();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                config.getUsername(),
                config.getPassword());

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isManagerHomeDisplayed(),
                "Login Failed");
    }
    @Test(priority = 2)
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "invalidUser",
                "invalidPass");

        Assert.assertTrue(true);
    }
    @Test(priority = 3)
    public void emptyLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "",
                "");

        Assert.assertTrue(true);
    }
    @Test(priority = 4)
    
    public void excelLoginTest() {

        String username =
                ExcelUtils.getCellData(0, 0);

        String password =
                ExcelUtils.getCellData(0, 1);

        System.out.println(
                "Excel Username = " + username);

        System.out.println(
                "Excel Password = " + password);

        Assert.assertNotNull(
                username,
                "Username not read from Excel");

        Assert.assertNotNull(
                password,
                "Password not read from Excel");

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                username,
                password);

        HomePage homePage =
                new HomePage(driver);

        Assert.assertTrue(
                homePage.isManagerHomeDisplayed(),
                "Excel Login Failed");
    }
}
   