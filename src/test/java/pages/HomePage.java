package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By managerText = By.xpath("//marquee[contains(text(),'Welcome')]");

    public boolean isManagerHomeDisplayed() {
        return driver.findElement(managerText).isDisplayed();
    }
}