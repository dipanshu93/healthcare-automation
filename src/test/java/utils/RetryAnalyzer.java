package utils;

import org.testng.IRetryAnalyzer;

import org.testng.ITestResult;

public class RetryAnalyzer
        implements IRetryAnalyzer {

    int retryCount = 0;

    int maxRetryCount = 2;

    @Override
    public boolean retry(
            ITestResult result) {

        if (retryCount < maxRetryCount) {

            retryCount++;

            System.out.println(
                    "Retrying Test: "
                            + result.getName());

            return true;
        }

        return false;
    }
}