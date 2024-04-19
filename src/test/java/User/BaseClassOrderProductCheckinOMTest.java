package User;

import java.io.IOException;

import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepsitory.AdminHomePage;
import com.EasyWhiz.ObjectRepsitory.AdminLoginPage;
import com.EasyWhiz.ObjectRepsitory.CartPage;
import com.EasyWhiz.ObjectRepsitory.PaymentPage;
import com.EasyWhiz.ObjectRepsitory.UserHomePage;
import com.EasyWhiz.ObjectRepsitory.UserLonginPage;
import com.GenericUtilities.BaseClass;

public class BaseClassOrderProductCheckinOMTest extends BaseClass{
	@Test
	public void script() throws IOException, InterruptedException
	{
		
		String URL =futlis.readDataFromPropertyFile("urlA");
		String USER =futlis.readDataFromPropertyFile("username");
		String PASS =futlis.readDataFromPropertyFile("password");
		
		String URL2 = futlis.readDataFromPropertyFile("urlU");
		
		String USER1 = futlis.readDataFromPropertyFile("Email");
		String PASS1 = futlis.readDataFromPropertyFile("UPassword");
		
		
		driver.get(URL2);
		wutlis.waitPageLoad(driver, 20);

		Thread.sleep(5000);		
		UserHomePage userHomePage=new UserHomePage(driver);
		userHomePage.getLoginLink().click();
		UserLonginPage userLonginPage=new UserLonginPage(driver);
		userLonginPage.userloginToApp(USER1, PASS1);
		Thread.sleep(3000);
		String search = eutlis.readDataFromExcel("Admin", 6, 1);
		userHomePage.SearchProduct(search);
		Thread.sleep(3000);
		wutlis.acceptAlert(driver);
		
		CartPage cartPage=new CartPage(driver);
		cartPage.orderProduct();
		
		PaymentPage paymentPage=new PaymentPage(driver);
		paymentPage.orderProduct();
		userHomePage.logoutFromPage();
		Thread.sleep(2000);
		driver.get(URL);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.loginToApp(USER, PASS);
        Thread.sleep(2000);
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        adminHomePage.clickonOrdermanagament();
        adminHomePage.getOrderToady().click();
		adminHomePage.clickonLogout();
	}
}
