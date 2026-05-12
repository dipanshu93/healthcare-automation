package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By pimMenu =
            By.xpath("//span[text()='PIM']");

    // Action
    public void clickPIM() {
        driver.findElement(pimMenu).click();
    }
}