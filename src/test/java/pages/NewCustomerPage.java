package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {

    WebDriver driver;

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    // New Customer Menu
    By newCustomerLink = By.linkText("New Customer");

    // Form Fields
    By customerName = By.name("name");

    By maleRadio =
            By.xpath("//input[@value='m']");

    By dob = By.id("dob");

    By address = By.name("addr");

    By city = By.name("city");

    By state = By.name("state");

    By pin = By.name("pinno");

    By mobile =
            By.name("telephoneno");

    By email =
            By.name("emailid");

    By password =
            By.name("password");

    By submitBtn =
            By.name("sub");

    // Customer ID on Success Page
    By customerIdText =
            By.xpath("//table//tr[4]/td[2]");

    public void clickNewCustomer() {

        driver.findElement(
                newCustomerLink).click();
    }

    public void addCustomer(
            String cname,
            String birthDate,
            String addr,
            String cityName,
            String stateName,
            String pinCode,
            String mobileNo,
            String emailId,
            String pwd) {

        driver.findElement(customerName)
                .sendKeys(cname);

        driver.findElement(maleRadio)
                .click();

        driver.findElement(dob)
                .sendKeys(birthDate);

        driver.findElement(address)
                .sendKeys(addr);

        driver.findElement(city)
                .sendKeys(cityName);

        driver.findElement(state)
                .sendKeys(stateName);

        driver.findElement(pin)
                .sendKeys(pinCode);

        driver.findElement(mobile)
                .sendKeys(mobileNo);

        driver.findElement(email)
                .sendKeys(emailId);

        driver.findElement(password)
                .sendKeys(pwd);

        driver.findElement(submitBtn)
                .click();

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public String getCustomerId() {

        return driver.findElement(
                customerIdText).getText();
    }
}