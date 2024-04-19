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

public class SignupcheckTest 
{
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
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(2000);
		
       
		driver.findElement(By.id("fullname")).sendKeys(gexc.readDataFromExcel("User", 0, 1));
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(gexc.readDataFromExcel("User", 1, 1));
		Thread.sleep(1000);
		driver.findElement(By.id("contactno")).sendKeys(gexc.readDataFromExcel("User", 2, 1));
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(gexc.readDataFromExcel("User", 3, 1));
		Thread.sleep(1000);
		driver.findElement(By.id("confirmpassword")).sendKeys(gexc.readDataFromExcel("User", 3, 1));
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
		gwebdri.acceptAlert(driver);
		Thread.sleep(2000);
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USER1);
		Thread.sleep(1000);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(gexc.readDataFromExcel("User", 3, 1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);
		driver.get(URL1);
		driver.findElement(By.name("username")).sendKeys(USER);
		driver.findElement(By.name("password")).sendKeys(PASS);
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'manage-users.php')]")).click();
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(gexc.readDataFromExcel("User", 0, 1));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);
	}

}
