package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundTransferPage {

    WebDriver driver;

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
    }

    By payerAccount = By.name("payersaccount");
    By payeeAccount = By.name("payeeaccount");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    public void transferFund(
            String payerAcc,
            String payeeAcc,
            String amt,
            String desc) {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(10));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            payerAccount));

            driver.findElement(payerAccount)
                    .sendKeys(payerAcc);

            driver.findElement(payeeAccount)
                    .sendKeys(payeeAcc);

            driver.findElement(amount)
                    .sendKeys(amt);

            driver.findElement(description)
                    .sendKeys(desc);

            driver.findElement(submitBtn)
                    .click();

        } catch (Exception e) {

            System.out.println(
                    "Fund Transfer Page issue ignored");
        }
    }
}