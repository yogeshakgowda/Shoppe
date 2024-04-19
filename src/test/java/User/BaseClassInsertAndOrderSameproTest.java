package User;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import com.GenericUtilities.BaseClass;

public class BaseClassInsertAndOrderSameproTest extends BaseClass{
	@Test
	public void script() throws IOException, InterruptedException
	{
	
		String URL =futlis.readDataFromPropertyFile("urlA");
		String USER =futlis.readDataFromPropertyFile("username");
		String PASS =futlis.readDataFromPropertyFile("password");
		
		String URL2 = futlis.readDataFromPropertyFile("urlU");
		
		String USER1 = futlis.readDataFromPropertyFile("Email");
		String PASS1 = futlis.readDataFromPropertyFile("UPassword");
		
	
		driver.get(URL);

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.loginToApp(USER, PASS);

        Thread.sleep(2000);
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        adminHomePage.clickonCreateCategory();


        String Create= eutlis.readDataFromExcel("Admin", 0, 1);
        String subdesc=eutlis.readDataFromExcel("Admin", 1, 1);
        CreateCategoryPage createCategoryPage=new CreateCategoryPage(driver);
        createCategoryPage.enterIntoCreateCategory(Create, subdesc);
        Thread.sleep(3000);
        

        
        adminHomePage.clickonSubCreate();
        Thread.sleep(2000);
        SubCategoryPage subCategoryPage=new SubCategoryPage(driver);
        WebElement drop = subCategoryPage.getCreateDropdown();
        wutlis.dropDown(drop, "Sports");
        Thread.sleep(2000);
        String desc=eutlis.readDataFromExcel("Admin", 3, 1);
        subCategoryPage.enterIntosubCategory(desc);
		Thread.sleep(2000);
		
		
		

		String pn = eutlis.readDataFromExcel("Admin", 6, 1);
		String pc = eutlis.readDataFromExcel("Admin", 7, 1);
		String pbd = eutlis.readDataFromExcel("Admin", 8, 1);
		String pad = eutlis.readDataFromExcel("Admin", 9, 1);
		String ps = eutlis.readDataFromExcel("Admin", 10, 1);
		String img1 = eutlis.readDataFromExcel("Admin", 12, 1);
		String img2 = eutlis.readDataFromExcel("Admin", 12, 1);
		Thread.sleep(1000);
	
		adminHomePage.clickoninsertProduct();
		InsertProductPage insertProductPage=new InsertProductPage(driver);
		WebElement cDrop = insertProductPage.getCreateDropdown();
		wutlis.dropDown(cDrop, "Sports");
		WebElement sDrop = insertProductPage.getSubCategoryDdrop();
		wutlis.dropDown(sDrop, "FootBall");
		WebElement proDrop = insertProductPage.getProductAvailabilityDrop();
		wutlis.dropDown(proDrop, "In Stock");
		Thread.sleep(2000);
		insertProductPage.enterIntoInsertproduct(pn, pc, pbd, pad, ps, img1, img2);
		Thread.sleep(2000);
		adminHomePage.clickonLogout();

		driver.get(URL2);
		String exp="Shopping Portal Home Page";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println(act);
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
	}
}
