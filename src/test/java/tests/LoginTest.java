package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.DataProvider;

import utils.ExcelUtil;

@Listeners(listeners.TestListener.class)

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")

    public Object[][] getLoginData()
            throws Exception {

        return ExcelUtil.getTestData(
                "src/test/resources/testdata/LoginData.xlsx",
                "Sheet1");
    }

    @Test(
    	    dataProvider = "loginData",
    	    retryAnalyzer = utils.RetryAnalyzer.class
    	)

    public void loginTest(
            String username,
            String password) {

        LoginPage login =
                new LoginPage(driver);

        login.login(username, password);

        System.out.println(
                "Testing with: "
                        + username
                        + " / "
                        + password);

        // Valid Login
        if (username.equals("Admin")
                && password.equals("admin123")) {

            Assert.assertTrue(
                    login.isDashboardDisplayed());
        }

        // Invalid Login
        else {

            Assert.assertTrue(
                    login.getErrorMessage()
                            .contains("Invalid"));
        }
    }
}