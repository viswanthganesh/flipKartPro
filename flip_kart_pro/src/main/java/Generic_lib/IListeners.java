package Generic_lib;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class IListeners implements ITestListener
{
	 ExtentReports report;
	 ExtentTest test;

	public void onFinish(ITestContext arg0) 
	{
		report.flush();
		
	}

	public void onStart(ITestContext context) 
	{
		
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File("./ExtentReport.html"));	
		htmlReport.config().setDocumentTitle("VTIGER");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("smokeTest");
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("os platform", "windows 7");
		report.setSystemInfo("tset url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "viswanth G");
		
	}

	

	public void onTestFailure(ITestResult result)
	{
		//WebDriver driver = null;
		test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed" );
		test.log(Status.FAIL, result.getThrowable());
//		EventFiringWebDriver evnt = new EventFiringWebDriver(driver);
//		File src = evnt.getScreenshotAs(OutputType.FILE);
//		String path = ("./screenshort"+result.getMethod().getMethodName()+".PNG");
//		File dst = new File(path);
//		try {
//			Files.copy(src, dst);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
	}

	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, result.getMethod().getMethodName()+"is skiped");
		
		
	}

	public void onTestStart(ITestResult result) 
	{
		
		test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
	
		test.log(Status.PASS, result.getMethod().getMethodName()+"is passed");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
  
}
