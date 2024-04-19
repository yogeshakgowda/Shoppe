package User;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class PomInsertAndOrderSameproductTest {
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
		driver.get(URL);
//		driver.findElement(By.name("username")).sendKeys(USER);
//		driver.findElement(By.name("password")).sendKeys(PASS);
//		Thread.sleep(1000);
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(2000);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.loginToApp(USER, PASS);
//	    driver.findElement(By.xpath("//a[contains(text(),'Create Category')]")).click();
        Thread.sleep(2000);
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        adminHomePage.clickonCreateCategory();

//		driver.findElement(By.name("category")).sendKeys(gexc.readDataFromExcel("Admin", 0, 1));
//		driver.findElement(By.name("description")).sendKeys(gexc.readDataFromExcel("Admin", 1, 1)); 
//		Thread.sleep(1000);
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(1000);
        
        String Create= gexc.readDataFromExcel("Admin", 0, 1);
        String subdesc=gexc.readDataFromExcel("Admin", 1, 1);
        CreateCategoryPage createCategoryPage=new CreateCategoryPage(driver);
        createCategoryPage.enterIntoCreateCategory(Create, subdesc);
        Thread.sleep(3000);
        
//		driver.findElement(By.xpath("//a[contains(text(),'Sub Category')]")).click();
//		Thread.sleep(2000);
//		WebElement drop = driver.findElement(By.cssSelector("select[name='category']"));
//		
//		gwebdri.dropDown(drop, "Sports");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(gexc.readDataFromExcel("Admin", 3, 1));
//		Thread.sleep(2000);
//		driver.findElement(By.name("submit")).click();
        
        
        adminHomePage.clickonSubCreate();
        Thread.sleep(2000);
        SubCategoryPage subCategoryPage=new SubCategoryPage(driver);
        WebElement drop = subCategoryPage.getCreateDropdown();
        gwebdri.dropDown(drop, "Sports");
        Thread.sleep(2000);
        String desc=gexc.readDataFromExcel("Admin", 3, 1);
        subCategoryPage.enterIntosubCategory(desc);
		Thread.sleep(2000);
		
		
		
//		driver.findElement(By.xpath("//a[contains(text(),'Insert Product')]")).click();
//		Thread.sleep(2000);
//		WebElement drop1 = driver.findElement(By.name("category"));
//		gwebdri.dropDown(drop1, "Sports");
//		WebElement drop2 = driver.findElement(By.name("subcategory"));
//		gwebdri.dropDown(drop2, "FootBall");
//		driver.findElement(By.name("productName")).sendKeys(gexc.readDataFromExcel("Admin", 6, 1));
//		Thread.sleep(1000);
//		driver.findElement(By.name("productCompany")).sendKeys(gexc.readDataFromExcel("Admin", 7, 1));
//		Thread.sleep(1000);
//		driver.findElement(By.name("productpricebd")).sendKeys(gexc.readDataFromExcel("Admin", 8, 1));
//		Thread.sleep(1000);
//		driver.findElement(By.name("productprice")).sendKeys(gexc.readDataFromExcel("Admin", 9, 1));
//		Thread.sleep(1000);
//		driver.findElement(By.name("productShippingcharge")).sendKeys(gexc.readDataFromExcel("Admin", 10, 1));
//		Thread.sleep(1000);
//		WebElement drop3 = driver.findElement(By.name("productAvailability"));
//		gwebdri.dropDown(drop3, "In Stock");
//		Thread.sleep(1000);
//		driver.findElement(By.name("productimage1")).sendKeys(gexc.readDataFromExcel("Admin", 12, 1));
//		Thread.sleep(1000);
//		driver.findElement(By.name("productimage2")).sendKeys(gexc.readDataFromExcel("Admin", 12, 1));
//		Thread.sleep(1000);
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(5000);
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
		WebElement sDrop = insertProductPage.getSubCategoryDdrop();
		gwebdri.dropDown(sDrop, "FootBall");
		WebElement proDrop = insertProductPage.getProductAvailabilityDrop();
		gwebdri.dropDown(proDrop, "In Stock");
		Thread.sleep(2000);
		insertProductPage.enterIntoInsertproduct(pn, pc, pbd, pad, ps, img1, img2);
		Thread.sleep(2000);
		adminHomePage.clickonLogout();
//		driver.findElement(By.linkText("Logout")).click();
//		Thread.sleep(3000);
		driver.get(URL2);
		gwebdri.waitPageLoad(driver, 20);
		Thread.sleep(5000);
		
//		driver.findElement(By.xpath("//a[text()='Login']")).click();
//		Thread.sleep(3000);
		
		UserHomePage userHomePage=new UserHomePage(driver);
		userHomePage.getLoginLink().click();
		UserLonginPage userLonginPage=new UserLonginPage(driver);
		userLonginPage.userloginToApp(USER1, PASS1);
		Thread.sleep(3000);
		String search = gexc.readDataFromExcel("Admin", 6, 1);
		userHomePage.SearchProduct(search);
		Thread.sleep(3000);
		gwebdri.acceptAlert(driver);
		
		CartPage cartPage=new CartPage(driver);
		cartPage.orderProduct();
		
		PaymentPage paymentPage=new PaymentPage(driver);
		paymentPage.orderProduct();
		
		userHomePage.logoutFromPage();
		
//		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USER1);
//		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASS1);
//		driver.findElement(By.xpath("//button[text()='Login']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(gexc.readDataFromExcel("Admin", 6, 1));
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[@class='search-button']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
//		Thread.sleep(1000);
//		driver.switchTo().alert().accept();
//		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[contains(text(),'Track')]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Logout")).click();
	}
}
