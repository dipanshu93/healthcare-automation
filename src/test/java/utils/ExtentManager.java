package utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            System.out.println(
                    "Creating Extent Report...");

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(
                            "test-output/ExtentReport.html");

            reporter.config()
                    .setReportName(
                            "Healthcare CRM Automation");

            reporter.config()
                    .setDocumentTitle(
                            "Automation Test Results");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }
}