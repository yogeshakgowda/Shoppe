package Admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class Manageproduct1Test {
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
		driver.findElement(By.name("username")).sendKeys(USER);
		driver.findElement(By.name("password")).sendKeys(PASS);
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[contains(text(),'Create Category')]")).click();
	    Thread.sleep(2000);
	    

		driver.findElement(By.name("category")).sendKeys(gexc.readDataFromExcel("Admin", 0, 1));
		driver.findElement(By.name("description")).sendKeys(gexc.readDataFromExcel("Admin", 1, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Sub Category')]")).click();
		Thread.sleep(2000);
		WebElement drop = driver.findElement(By.cssSelector("select[name='category']"));
		
		gwebdri.dropDown(drop, "Sports");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(gexc.readDataFromExcel("Admin", 3, 1));
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Insert Product')]")).click();
		Thread.sleep(2000);
		WebElement drop1 = driver.findElement(By.name("category"));
		gwebdri.dropDown(drop1, "Sports");
		WebElement drop2 = driver.findElement(By.name("subcategory"));
		gwebdri.dropDown(drop2, "FootBall");
		driver.findElement(By.name("productName")).sendKeys(gexc.readDataFromExcel("Admin", 6, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("productCompany")).sendKeys(gexc.readDataFromExcel("Admin", 7, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("productpricebd")).sendKeys(gexc.readDataFromExcel("Admin", 8, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("productprice")).sendKeys(gexc.readDataFromExcel("Admin", 9, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("productShippingcharge")).sendKeys(gexc.readDataFromExcel("Admin", 10, 1));
		Thread.sleep(1000);
		WebElement drop3 = driver.findElement(By.name("productAvailability"));
		gwebdri.dropDown(drop3, "In Stock");
		Thread.sleep(1000);
		driver.findElement(By.name("productimage1")).sendKeys(gexc.readDataFromExcel("Admin", 12, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("productimage2")).sendKeys(gexc.readDataFromExcel("Admin", 12, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@href,'manage-products.php')]")).click();;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(gexc.readDataFromExcel("Admin", 6, 1));
		driver.findElement(By.xpath("//a[@href='edit-products.php?id=500']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='productShippingcharge']")).sendKeys("45");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
	}
}
