package User;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepsitory.MyAccountPage;
import com.EasyWhiz.ObjectRepsitory.UserHomePage;
import com.EasyWhiz.ObjectRepsitory.UserLonginPage;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class PomShippingTest 
{
	WebDriver driver;
	@Test
	public void script() throws IOException, InterruptedException
	{
		ExcelUtility gexc = new ExcelUtility();
		FileUtility gfile = new FileUtility();
		JavaUtility gjavuli=new JavaUtility();
		DatabaseUtility gdata = new DatabaseUtility();
		WebDriverUtility gwebdri = new WebDriverUtility();
		
		String BROWSER = gfile.readDataFromPropertyFile("browser");
		String URL2 = gfile.readDataFromPropertyFile("urlU");
		
		String USER1 = gfile.readDataFromPropertyFile("EmailAdd1");
		String PASS1 = gfile.readDataFromPropertyFile("cpass1");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver(); 
		}
		
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		gwebdri.maximizebroswer(driver);
		driver.get(URL2);
		gwebdri.waitPageLoad(driver, 20);
		
		
		UserHomePage userHomePage=new UserHomePage(driver);
		userHomePage.ClickOnLogin();;
		Thread.sleep(2000);
		
		UserLonginPage userLonginPage=new UserLonginPage(driver);
		userLonginPage.userloginToApp(USER1, PASS1);
		Thread.sleep(2000);
		
		userHomePage.ClickOnMyAccount();
		Thread.sleep(1000);
		
		String BillAdd = gexc.readDataFromExcel("User", 5, 1);
		String BillSt= gexc.readDataFromExcel("User", 6, 1);
		String Billcity = gexc.readDataFromExcel("User", 7, 1);
		String Billpin = gexc.readDataFromExcel("User", 8, 1);
		String shipAdd = gexc.readDataFromExcel("User", 9, 1);
		String shipsta = gexc.readDataFromExcel("User", 10, 1);
		String shipcity = gexc.readDataFromExcel("User", 11, 1);
		String shippin = gexc.readDataFromExcel("User", 12, 1);
		
		MyAccountPage myAccountPage=new MyAccountPage(driver);
		myAccountPage.BillingAddressUpdate(BillAdd, BillSt, Billcity, Billpin);
		gwebdri.acceptAlert(driver);
		Thread.sleep(2000);
		myAccountPage.ShippingAddressUpdate(shipAdd, shipsta, shipcity, shippin);
		gwebdri.acceptAlert(driver);
		Thread.sleep(2000);
		
		String txt = gexc.readDataFromExcel("Admin", 6, 1);
		userHomePage.SearchProduct(txt);
		gwebdri.acceptAlert(driver);
		Thread.sleep(2000);
	}
}
