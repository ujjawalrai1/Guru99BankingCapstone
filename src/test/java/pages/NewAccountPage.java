package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {

    WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By newAccountLink = By.linkText("New Account");
    By customerId = By.name("cusid");
    By accountType = By.name("selaccount");
    By initialDeposit = By.name("inideposit");
    By submitBtn = By.name("button2");

    public void clickNewAccount() {
        driver.findElement(newAccountLink).click();
    }

    public void createAccount(String custId, String deposit) {

        driver.findElement(customerId).clear();
        driver.findElement(customerId).sendKeys(custId);

        Select select =
                new Select(driver.findElement(accountType));

        select.selectByVisibleText("Savings");

        driver.findElement(initialDeposit).clear();
        driver.findElement(initialDeposit).sendKeys(deposit);

        driver.findElement(submitBtn).click();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

    public String getAccountId() {

        try {

            return driver.findElement(
                    By.xpath("//td[text()='Account ID']/following-sibling::td"))
                    .getText()
                    .trim();

        } catch (Exception e) {

            System.out.println("Account ID not found");
            return "";
        }
    }
}