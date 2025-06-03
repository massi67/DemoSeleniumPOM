package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Tests.BaseTest;

public class TestListener extends BaseTest implements ITestListener {

	private ExtentTest test;
	   
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }
 
    public void onTestStart(ITestResult result) {
        // Create ExtentTest instance for each test method
        test = ExtentManager.createTest(result.getMethod().getMethodName());
    }
    
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed!!");
        test.info("Adding some info for test");
    }
   
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed!!");
        test.fail(result.getThrowable());
        //String screenshotPath = Utility.takeScreenshot(result.getName());
		//System.out.println("Screenshot path : "+screenshotPath);
		//test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
    }
 
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped");
    }
    
    public void onFinish(ITestContext context) {
        // Flush ExtentReports
        ExtentManager.getInstance().flush();
    }
}
