package User;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic.Ulitity_Excel;

public class ShippingAndBillingAddUpdateTest {
	WebDriver driver;
@Test
public void shop() throws IOException, InterruptedException
{
	FileInputStream fis = new FileInputStream("./src/test/resources/Common.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String BROWSER = pobj.getProperty("browser");
	String URL = pobj.getProperty("urlU");
	String USERY = pobj.getProperty("EmailAdd");
	String PASSY = pobj.getProperty("cpass");
	
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERY);
	driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSY);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@href='bill-ship-addresses.php']")).click();
	Thread.sleep(1000);
	
	Ulitity_Excel ue= new Ulitity_Excel();
	
	driver.findElement(By.xpath("//textarea[@name='billingaddress']")).sendKeys(ue.select_Excel1("Billing Address"));
	Thread.sleep(1000);
	driver.findElement(By.id("bilingstate")).sendKeys(ue.select_Excel1("Billing State"));
	Thread.sleep(1000);
	driver.findElement(By.id("billingcity")).sendKeys(ue.select_Excel1("Billing City"));
	Thread.sleep(1000);
	driver.findElement(By.id("billingpincode")).sendKeys(ue.select_Excel1("Billing Pincode"));
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
	Thread.sleep(2000);
	
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//a[@href='#collapseTwo']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@name='shippingaddress']")).sendKeys(ue.select_Excel1("Shipping Address"));
	Thread.sleep(1000);
	driver.findElement(By.id("shippingstate")).sendKeys(ue.select_Excel1("Shipping State"));
	Thread.sleep(1000);
	driver.findElement(By.id("shippingcity")).sendKeys(ue.select_Excel1("Shipping City"));
	Thread.sleep(1000);
	driver.findElement(By.id("shippingpincode")).sendKeys(ue.select_Excel1("Shipping Pincode"));
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(ue.select_Excel("Product name:"));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@class='search-button']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
}
}
