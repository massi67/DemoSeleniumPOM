package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
 
    public static ExtentReports getInstance() {
    	if (extent == null) {
            extent = new ExtentReports();
           ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
 
 
    public static ExtentTest createTest(String testName) {
        return extent.createTest(testName);
    }
}
