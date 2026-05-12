package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeTest extends BaseTest {

	@Test
	public void addEmployeeTest() {

		// Login
		LoginPage login = new LoginPage(driver);

		login.login("Admin", "admin123");

		Assert.assertTrue(login.isDashboardDisplayed());

		// Navigate to PIM
		DashboardPage dashboard = new DashboardPage(driver);

		dashboard.clickPIM();

		// Add Employee
		PIMPage pim = new PIMPage(driver);

		pim.clickAddEmployee();

		pim.enterFirstName("John");

		pim.enterLastName("Doe");

		pim.clickSave();

		// Validation
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement successMessage = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Successfully Saved')]")
        ));

Assert.assertTrue(successMessage.isDisplayed());
	}
}
