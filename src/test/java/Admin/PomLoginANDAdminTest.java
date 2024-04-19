package Admin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepsitory.AdminHomePage;
import com.EasyWhiz.ObjectRepsitory.AdminLoginPage;
import com.EasyWhiz.ObjectRepsitory.CartPage;
import com.EasyWhiz.ObjectRepsitory.CreateCategoryPage;
import com.EasyWhiz.ObjectRepsitory.InsertProductPage;
import com.EasyWhiz.ObjectRepsitory.PaymentPage;
import com.EasyWhiz.ObjectRepsitory.SubCategoryPage;
import com.EasyWhiz.ObjectRepsitory.UserHomePage;
import com.EasyWhiz.ObjectRepsitory.UserLonginPage;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class PomLoginANDAdminTest {
	WebDriver driver=null;
	@Test
	public void script() throws IOException, InterruptedException
	{
		ExcelUtility gexc = new ExcelUtility();
		FileUtility gfile = new FileUtility();
		JavaUtility gjavuli=new JavaUtility();
		DatabaseUtility gdata = new DatabaseUtility();
		WebDriverUtility gwebdri = new WebDriverUtility();
		
		String BROWSER = gfile.readDataFromPropertyFile("browser");
		String URL =gfile.readDataFromPropertyFile("urlA");
		String USER =gfile.readDataFromPropertyFile("username");
		String PASS =gfile.readDataFromPropertyFile("password");
		
		String URL2 = gfile.readDataFromPropertyFile("urlU");
		
		String USER1 = gfile.readDataFromPropertyFile("Email");
		String PASS1 = gfile.readDataFromPropertyFile("UPassword");
		
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
		gwebdri.waitPageLoad(driver, 20);
		driver.get(URL);

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.loginToApp(USER, PASS);
        Thread.sleep(2000);
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        adminHomePage.clickonLogout();
        Thread.sleep(5000);
		driver.get(URL2);
		Thread.sleep(5000);

		UserHomePage userHomePage=new UserHomePage(driver);
		userHomePage.getLoginLink().click();
		UserLonginPage userLonginPage=new UserLonginPage(driver);
		userLonginPage.userloginToApp(USER1, PASS1);
		Thread.sleep(3000);
		userHomePage.logoutFromPage();

	}
}
