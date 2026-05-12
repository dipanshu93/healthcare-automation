package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

    public PIMPage(WebDriver driver) {

        super(driver);
    }

    // Locators
    By addEmployeeButton =
            By.xpath("//a[text()='Add Employee']");

    By firstName =
            By.name("firstName");

    By lastName =
            By.name("lastName");

    By saveButton =
            By.xpath("//button[@type='submit']");

    By successMessage =
            By.xpath("//h6[text()='Personal Details']");

    // Actions
    public void clickAddEmployee() {

        click(addEmployeeButton);
    }

    public void enterFirstName(String fname) {

        type(firstName, fname);
    }

    public void enterLastName(String lname) {

        type(lastName, lname);
    }

    public void clickSave() {

        click(saveButton);
    }

    public boolean isEmployeeAdded() {

        return isDisplayed(successMessage);
    }
}