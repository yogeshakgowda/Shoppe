package User;

import java.io.IOException;

import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepsitory.MyAccountPage;
import com.EasyWhiz.ObjectRepsitory.UserHomePage;
import com.EasyWhiz.ObjectRepsitory.UserLonginPage;
import com.GenericUtilities.BaseClass;

public class BaseClassShippingTest extends BaseClass{
	@Test
	public void script() throws IOException, InterruptedException
	{
		String URL2 = futlis.readDataFromPropertyFile("urlU");
		
		String USER1 = futlis.readDataFromPropertyFile("EmailAdd1");
		String PASS1 = futlis.readDataFromPropertyFile("cpass1");
		
		
		driver.get(URL2);
		wutlis.waitPageLoad(driver, 20);
		
		
		UserHomePage userHomePage=new UserHomePage(driver);
		userHomePage.ClickOnLogin();;
		Thread.sleep(2000);
		
		UserLonginPage userLonginPage=new UserLonginPage(driver);
		userLonginPage.userloginToApp(USER1, PASS1);
		Thread.sleep(2000);
		
		userHomePage.ClickOnMyAccount();
		Thread.sleep(1000);
		
		String BillAdd = eutlis.readDataFromExcel("User", 5, 1);
		String BillSt= eutlis.readDataFromExcel("User", 6, 1);
		String Billcity = eutlis.readDataFromExcel("User", 7, 1);
		String Billpin = eutlis.readDataFromExcel("User", 8, 1);
		String shipAdd = eutlis.readDataFromExcel("User", 9, 1);
		String shipsta = eutlis.readDataFromExcel("User", 10, 1);
		String shipcity = eutlis.readDataFromExcel("User", 11, 1);
		String shippin = eutlis.readDataFromExcel("User", 12, 1);
		
		MyAccountPage myAccountPage=new MyAccountPage(driver);
		myAccountPage.BillingAddressUpdate(BillAdd, BillSt, Billcity, Billpin);
		wutlis.acceptAlert(driver);
		Thread.sleep(2000);
		myAccountPage.ShippingAddressUpdate(shipAdd, shipsta, shipcity, shippin);
		wutlis.acceptAlert(driver);
		Thread.sleep(2000);
		
		String txt = eutlis.readDataFromExcel("Admin", 6, 1);
		userHomePage.SearchProduct(txt);
		wutlis.acceptAlert(driver);
		Thread.sleep(2000);
	}
}
