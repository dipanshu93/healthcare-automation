package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

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
		Assert.assertTrue(false);
	}
}