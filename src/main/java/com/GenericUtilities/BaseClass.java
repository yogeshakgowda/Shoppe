package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
	public DatabaseUtility Dutlis=new DatabaseUtility();
	public ExcelUtility eutlis=new ExcelUtility();
	public FileUtility futlis=new FileUtility();
	public WebDriverUtility wutlis= new WebDriverUtility();
	public JavaUtility jutlis=new JavaUtility();
@BeforeSuite(alwaysRun = true)
public void connectToDB() throws SQLException
{ 
	Dutlis.connectToDB();
	Reporter.log("---connect to DB---",true);
}

@BeforeClass(alwaysRun = true)
public void launchBrowser() throws IOException
{
	String BROWSER = futlis.readDataFromPropertyFile("browser");
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
	else
	{
		Reporter.log("---invalid browser---",true);
	}
	
	sdriver=driver;
	wutlis.maximizebroswer(driver);
}
@AfterClass//(alwaysRun = true)
public void closeBrowser()
{
	driver.quit();
	Reporter.log("---close browser---",true);
}

@AfterSuite//(alwaysRun = true)
public void closeDB() throws SQLException
{
	Dutlis.closeDB();
	Reporter.log("---close DB---",true);
}
}
