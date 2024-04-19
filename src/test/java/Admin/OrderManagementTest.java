package Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import Generic.Ulitity_Excel;
import Generic.WebdriverUtility;

public class OrderManagementTest {
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
		driver.get(URL2);
		gwebdri.waitPageLoad(driver, 20);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USER1);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASS1);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(gexc.readDataFromExcel("Admin", 6, 1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		Thread.sleep(4000);
		gwebdri.acceptAlert(driver);		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Track')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		
		String URL = gfile.readDataFromPropertyFile("urlA");
		String USER = gfile.readDataFromPropertyFile("username");
		String PASS = gfile.readDataFromPropertyFile("password");
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(USER);
		driver.findElement(By.name("password")).sendKeys(PASS);
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@href='#togglePages']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@href='todays-orders.php']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Logout")).click();
	}

}
