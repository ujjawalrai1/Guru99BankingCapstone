package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithdrawalPage {

    WebDriver driver;

    public WithdrawalPage(WebDriver driver) {
        this.driver = driver;
    }

    By withdrawalLink = By.linkText("Withdrawal");

    By accountNo = By.name("accountno");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    public void clickWithdrawal() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement withdrawal =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                withdrawalLink));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                withdrawal);
    }

    public void withdrawAmount(
            String accNo,
            String amt,
            String desc) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountNo));

        driver.findElement(accountNo).clear();
        driver.findElement(accountNo).sendKeys(accNo);

        driver.findElement(amount).clear();
        driver.findElement(amount).sendKeys(amt);

        driver.findElement(description).clear();
        driver.findElement(description).sendKeys(desc);

        driver.findElement(submitBtn).click();
    }
}