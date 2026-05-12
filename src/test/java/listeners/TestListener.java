package listeners;

import base.BaseTest;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener
        implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "STARTING EXECUTION");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println(
                "FINISHED EXECUTION");
    }

    @Override
    public void onTestStart(
            ITestResult result) {

        test = extent.createTest(
                result.getName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test.log(Status.PASS,
                "Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        test.log(Status.FAIL,
                "Test Failed");

        test.fail(result.getThrowable());

        String screenshotPath =

                ScreenshotUtil.captureScreenshot(
                        BaseTest.driver,
                        result.getName());

        try {

            test.addScreenCaptureFromPath(
                    screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        test.log(Status.SKIP,
                "Test Skipped");
    }
}