package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage {

    WebDriver driver;

    public DepositPage(WebDriver driver) {
        this.driver = driver;
    }

    By depositLink = By.linkText("Deposit");

    By accountNo = By.name("accountno");

    By amount = By.name("ammount");

    By description = By.name("desc");

    By submitBtn = By.name("AccSubmit");

    public void clickDeposit() {

        try {
            driver.findElement(depositLink).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Unable to open Deposit Page");
        }
    }

    public void depositAmount(
            String accNo,
            String amt,
            String desc) {

        try {

            Thread.sleep(3000);

            driver.findElement(accountNo).clear();
            driver.findElement(accountNo).sendKeys(accNo);

            driver.findElement(amount).clear();
            driver.findElement(amount).sendKeys(amt);

            driver.findElement(description).clear();
            driver.findElement(description).sendKeys(desc);

            driver.findElement(submitBtn).click();

            Thread.sleep(3000);

        } catch (Exception e) {

            System.out.println("Deposit Page Failed");
            System.out.println(e.getMessage());

        }
    }
}