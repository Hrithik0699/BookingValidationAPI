package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer {

    private int retryCount = Integer.parseInt(PropertiesFile.getProperty("retry.count"));;
    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
