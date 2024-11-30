package extentManager;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public ExtentTest test;

	public static ExtentReports extentReport() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports3\\myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Report");
		sparkReporter.config().setTheme(Theme.DARK);

		  extent = new ExtentReports();
		  extent.attachReporter(sparkReporter);
		  extent.setSystemInfo("hostname", "LocalHost");
		  extent.setSystemInfo("os", "windows8.1");
		  extent.setSystemInfo("testername", "Swamy");
		  
		 return extent;
	}
}
