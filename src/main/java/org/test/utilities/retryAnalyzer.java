package org.test.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer {
    int count = 0;
    int retryCount = 1;

    public boolean retry(ITestResult result) {
        while (count<retryCount){
            count++;
            return true;
        }
        return false;
    }
}