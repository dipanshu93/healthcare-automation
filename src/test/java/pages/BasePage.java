package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(10));
    }

    // Wait + Click
    public void click(By locator) {

        wait.until(
                ExpectedConditions
                        .elementToBeClickable(locator))
                .click();
    }

    // Wait + Send Keys
    public void type(By locator, String text) {

        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(locator))
                .sendKeys(text);
    }

    // Wait + Get Text
    public String getText(By locator) {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(locator))
                .getText();
    }

    // Wait + Display Check
    public boolean isDisplayed(By locator) {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(locator))
                .isDisplayed();
    }
}