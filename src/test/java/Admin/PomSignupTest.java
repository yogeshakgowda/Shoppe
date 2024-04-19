package Admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepsitory.AdminHomePage;
import com.EasyWhiz.ObjectRepsitory.AdminLoginPage;
import com.EasyWhiz.ObjectRepsitory.ManageUserPage;
import com.EasyWhiz.ObjectRepsitory.UserHomePage;
import com.EasyWhiz.ObjectRepsitory.UserLonginPage;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class PomSignupTest {

	WebDriver driver=null;
	@Test
	public void testScript() throws InterruptedException, IOException
	{
		ExcelUtility gexc = new ExcelUtility();
		FileUtility gfile = new FileUtility();
		JavaUtility gjavuli=new JavaUtility();
		DatabaseUtility gdata = new DatabaseUtility();
		WebDriverUtility gwebdri = new WebDriverUtility();
		
		String BROWSER = gfile.readDataFromPropertyFile("browser");
		String URL2 = gfile.readDataFromPropertyFile("urlU");
		String USER = gfile.readDataFromPropertyFile("username");
		String PASS = gfile.readDataFromPropertyFile("password");
		
		String URL1 = gfile.readDataFromPropertyFile("urlA");
		
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
		userHomePage.getLoginLink().click();
		String fullNamae = gexc.readDataFromExcel("User", 0, 1);
		String mail = gexc.readDataFromExcel("User", 1, 1);
		String conn = gexc.readDataFromExcel("User", 2, 1);
		String passw = gexc.readDataFromExcel("User", 3, 1);
		String cpassw = gexc.readDataFromExcel("User", 3, 1);
		
		UserLonginPage userLonginPage=new UserLonginPage(driver);
		userLonginPage.SignupAs(fullNamae, mail, conn, passw, cpassw);
		Thread.sleep(3000);
		gwebdri.acceptAlert(driver);
		Thread.sleep(3000);
		userLonginPage.userloginToApp(mail, cpassw);
		Thread.sleep(2000);
		userHomePage.logoutFromPage();
		
		driver.get(URL1);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.loginToApp(USER, PASS);
		Thread.sleep(2000);
		
		AdminHomePage adminHomePage = new AdminHomePage(driver);
        adminHomePage.clickonManageUser();
        
        ManageUserPage manageUserPage=new ManageUserPage(driver);
        manageUserPage.manageUserUpdate(fullNamae);
		
		Thread.sleep(1000);
		
		adminHomePage.clickonLogout();
		
		Thread.sleep(1000);
	}

}
