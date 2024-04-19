package User;

import java.io.IOException;

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

public class ShippingGTest {
	WebDriver driver;
@Test
public void script() throws IOException, InterruptedException
{
	ExcelUtility gexc = new ExcelUtility();
	FileUtility gfile = new FileUtility();
	JavaUtility gjavuli=new JavaUtility();
	DatabaseUtility gdata = new DatabaseUtility();
	WebDriverUtility gwebdri = new WebDriverUtility();
	
	String BROWSER = gfile.readDataFromPropertyFile("browser");
	String URL2 = gfile.readDataFromPropertyFile("urlU");
	
	String USER1 = gfile.readDataFromPropertyFile("EmailAdd");
	String PASS1 = gfile.readDataFromPropertyFile("cpass");
	
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
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("exampleInputEmail1")).sendKeys(USER1);
	driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASS1);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@href='bill-ship-addresses.php']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@name='billingaddress']")).sendKeys(gexc.readDataFromExcel("User", 5, 1));
	Thread.sleep(1000);
	driver.findElement(By.id("bilingstate")).sendKeys(gexc.readDataFromExcel("User", 6, 1));
	Thread.sleep(1000);
	driver.findElement(By.id("billingcity")).sendKeys(gexc.readDataFromExcel("User", 7, 1));
	Thread.sleep(1000);
	driver.findElement(By.id("billingpincode")).sendKeys(gexc.readDataFromExcel("User", 8, 1));
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
	Thread.sleep(5000);
	gwebdri.acceptAlert(driver);
	driver.findElement(By.xpath("//a[@href='#collapseTwo']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@name='shippingaddress']")).sendKeys(gexc.readDataFromExcel("User", 9, 1));
	Thread.sleep(1000);
	driver.findElement(By.id("shippingstate")).sendKeys(gexc.readDataFromExcel("User", 10, 1));
	Thread.sleep(1000);
	driver.findElement(By.id("shippingcity")).sendKeys(gexc.readDataFromExcel("User", 11, 1));
	Thread.sleep(1000);
	driver.findElement(By.id("shippingpincode")).sendKeys(gexc.readDataFromExcel("User", 12, 1));
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
	Thread.sleep(5000);
	gwebdri.acceptAlert(driver);
	driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(gexc.readDataFromExcel("Admin", 6, 1));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@class='search-button']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	Thread.sleep(5000);
	gwebdri.acceptAlert(driver);
	Thread.sleep(2000);
}
}
