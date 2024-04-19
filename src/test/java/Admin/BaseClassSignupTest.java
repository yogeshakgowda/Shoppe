package Admin;

import java.io.IOException;

import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepsitory.AdminHomePage;
import com.EasyWhiz.ObjectRepsitory.AdminLoginPage;
import com.EasyWhiz.ObjectRepsitory.ManageUserPage;
import com.EasyWhiz.ObjectRepsitory.UserHomePage;
import com.EasyWhiz.ObjectRepsitory.UserLonginPage;
import com.GenericUtilities.BaseClass;

public class BaseClassSignupTest extends BaseClass
{
	@Test
	public void testScript() throws InterruptedException, IOException
	{
		
		String URL2 = futlis.readDataFromPropertyFile("urlU");
		String USER = futlis.readDataFromPropertyFile("username");
		String PASS = futlis.readDataFromPropertyFile("password");
		
		String URL1 = futlis.readDataFromPropertyFile("urlA");
		
		driver.get(URL2);
		wutlis.waitPageLoad(driver, 20);
		UserHomePage userHomePage=new UserHomePage(driver);
		userHomePage.getLoginLink().click();
		String fullNamae = eutlis.readDataFromExcel("User", 0, 1);
		String mail = eutlis.readDataFromExcel("User", 1, 1);
		String conn = eutlis.readDataFromExcel("User", 2, 1);
		String passw = eutlis.readDataFromExcel("User", 3, 1);
		String cpassw = eutlis.readDataFromExcel("User", 3, 1);
		
		UserLonginPage userLonginPage=new UserLonginPage(driver);
		userLonginPage.SignupAs(fullNamae, mail, conn, passw, cpassw);
		Thread.sleep(3000);
		wutlis.acceptAlert(driver);
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
