package com.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenericListeners implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log("Execution Starts From here",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName);
		Reporter.log(MethodName+"----->Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		try 
		{
			String ScreenShot = WebDriverUtility.getScreenShot(BaseClass.sdriver, MethodName);
			test.log(Status.FAIL, MethodName+"---Failed");
			test.log(Status.FAIL, result.getThrowable());
			
			test.addScreenCaptureFromPath(ScreenShot);
			Reporter.log(MethodName+"----->Failed");
		} 
		catch (Throwable e) 
		{
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"----Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"----->Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("EasyWhiz");
		htmlreport.config().setReportName("SDET-55");
		htmlreport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Platform", "windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Shopping_Application/");
		report.setSystemInfo("ReporterName", "Yogesha k");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

}
