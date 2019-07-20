package Main;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener extends TestBase implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {
		try {
			Web.BrowserInitialization();
		} catch (IOException e) {
			test.log(Status.FAIL , "Failed to instantiate browser");
			e.printStackTrace();
		}
		
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test passed (message by test listener)");
		 test.log(Status.PASS, "PASSED Test Case IS -" + result.getName());
		
		 driver.quit();
	}

	public void onTestFailure(ITestResult result) {
		//System.out.println("test failed (message by test listener)");
		
	//	 test.log(Status.FAIL, "FAILED Test Case IS - " ); // to add error/exception in extent report */
		 String screenshotPath;
		try {
			
			screenshotPath = TestBase.getScreenShot(driver);
			test.addScreenCaptureFromPath(screenshotPath);
			test = extent.createTest(result.getName());
		} catch (IOException e) {
			test = extent.createTest("Test Failed");
			test.log(Status.FAIL, "Failed to update onTestFailure");
		}
		
		driver.quit();
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.INFO, "Skipped test case is " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		htmlreport = new ExtentHtmlReporter("Report/HTML-Report/GDD-MDM-Report.html");
		htmlreport.config().setDocumentTitle("Moun's Report"); //Title of the report
		htmlreport.config().setReportName("Functional Testing"); //Name of the report
		htmlreport.config().setTheme(Theme.DARK);  // set by default theme
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Java Version", "1.8.4");
		extent.setSystemInfo("Hostname", "Local Host");
		extent.setSystemInfo("Tester Name", "Mounesh");
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

	public void onStart(ISuite suite) {
		
		
	}

	public void onFinish(ISuite suite) {
		extent.flush();
		
	}

}
