package Admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepsitory.AdminHomePage;
import com.EasyWhiz.ObjectRepsitory.AdminLoginPage;
import com.EasyWhiz.ObjectRepsitory.CreateCategoryPage;
import com.EasyWhiz.ObjectRepsitory.InsertProductPage;
import com.EasyWhiz.ObjectRepsitory.ManageProductPage;
import com.EasyWhiz.ObjectRepsitory.SubCategoryPage;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class PomManageproductTest {
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
        adminHomePage.clickonCreateCategory();
        
        String Create= gexc.readDataFromExcel("Admin", 0, 1);
        String subdesc=gexc.readDataFromExcel("Admin", 1, 1);
        CreateCategoryPage createCategoryPage=new CreateCategoryPage(driver);
        createCategoryPage.enterIntoCreateCategory(Create, subdesc);
        Thread.sleep(3000);
        
        adminHomePage.clickonSubCreate();
        Thread.sleep(2000);
        SubCategoryPage subCategoryPage=new SubCategoryPage(driver);
        WebElement drop = subCategoryPage.getCreateDropdown();
        gwebdri.dropDown(drop, "Sports");
        Thread.sleep(2000);
        String desc=gexc.readDataFromExcel("Admin", 3, 1);
        subCategoryPage.enterIntosubCategory(desc);
		Thread.sleep(2000);

		String pn = gexc.readDataFromExcel("Admin", 6, 1);
		String pc = gexc.readDataFromExcel("Admin", 7, 1);
		String pbd = gexc.readDataFromExcel("Admin", 8, 1);
		String pad = gexc.readDataFromExcel("Admin", 9, 1);
		String ps = gexc.readDataFromExcel("Admin", 10, 1);
		String img1 = gexc.readDataFromExcel("Admin", 12, 1);
		String img2 = gexc.readDataFromExcel("Admin", 12, 1);
		Thread.sleep(1000);
	
		adminHomePage.clickoninsertProduct();
		InsertProductPage insertProductPage=new InsertProductPage(driver);
		WebElement cDrop = insertProductPage.getCreateDropdown();
		gwebdri.dropDown(cDrop, "Sports");
		Thread.sleep(2000);
		WebElement sDrop = insertProductPage.getSubCategoryDdrop();
		gwebdri.dropDown(sDrop, "FootBall");
		Thread.sleep(2000);
		WebElement proDrop = insertProductPage.getProductAvailabilityDrop();
		gwebdri.dropDown(proDrop, "In Stock");
		Thread.sleep(2000);
		insertProductPage.enterIntoInsertproduct(pn, pc, pbd, pad, ps, img1, img2);
		Thread.sleep(2000);
		adminHomePage.clickonManageProduct();
		
		String Upd = gexc.readDataFromExcel("Admin", 6, 1);
		ManageProductPage manageProductPage=new ManageProductPage(driver);
		manageProductPage.manageProductUpdate(Upd);
		Thread.sleep(2000);
		adminHomePage.clickonLogout();
}
}