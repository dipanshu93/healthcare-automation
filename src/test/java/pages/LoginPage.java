package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Constructor
    public LoginPage(WebDriver driver) {

        super(driver);
    }

    // Locators
    By username = By.name("username");

    By password = By.name("password");

    By loginButton =
            By.xpath("//button[@type='submit']");

    By errorMessage =
            By.xpath("//p[contains(@class,'alert-content-text')]");

    // Actions
    public void login(String user, String pass) {

        type(username, user);

        type(password, pass);

        click(loginButton);
    }

    public String getErrorMessage() {

        return getText(errorMessage);
    }

    public boolean isDashboardDisplayed() {

        return driver.getCurrentUrl()
                .contains("dashboard");
    }
}