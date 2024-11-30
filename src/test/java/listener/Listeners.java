package listener;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import endtoendOrder.BaseTest;
import extentManager.ExtentReport;


public class Listeners extends BaseTest implements ITestListener{
    ExtentTest test;
	ExtentReports extent = ExtentReport.extentReport();
	
	public void onTestStart(ITestResult result) {
	    // not implemented
		test=extent.createTest(result.getName());
		
	  }

	  
	public void onTestSuccess(ITestResult result) {
		//System.out.println("Test Fassed");
	//	test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED is:" + result.getMethod().getMethodName());
	    // not implemented
	  }

	  
	public void onTestFailure(ITestResult result) {
	    // not implemented
		//System.out.println("Test Failed");
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filepath=null;
		try {
		 filepath =getScreenshot(result.getName(), driver); 
		
//		test.log(Status.FAIL, "Test case FAILED is:" + result.getMethod().getMethodName());
//		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath);
		
	  }
	public void onTestSkipped(ITestResult result) {
	    // not implemented
		System.out.println("Test Skipped");
		//test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getMethod().getMethodName());
	  }
	  
	public void onFinish(ITestContext context) {
	    // not implemented
		extent.flush();
	  }
}
