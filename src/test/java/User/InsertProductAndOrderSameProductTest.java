package User;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic.Ulitity_Excel;
import Generic.Ulitity_Select;
import Generic.WebdriverUtility;

public class InsertProductAndOrderSameProductTest 
{
	WebDriver driver=null;
@Test
public void testScript() throws InterruptedException, IOException
{
	FileInputStream fis = new FileInputStream("./src/test/resources/Common.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String BROWSER = pobj.getProperty("browser");
	String URL = pobj.getProperty("urlA");
	String USER = pobj.getProperty("username");
	String PASS = pobj.getProperty("password");
	
	String URL2 = pobj.getProperty("urlU");
	
	String USER1 = pobj.getProperty("Email");
	String PASS1 = pobj.getProperty("UPassword");
	
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
	driver.findElement(By.name("username")).sendKeys(USER);
	driver.findElement(By.name("password")).sendKeys(PASS);
	Thread.sleep(1000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(2000);
    driver.findElement(By.xpath("//a[contains(text(),'Create Category')]")).click();
    Thread.sleep(2000);
    
	Ulitity_Excel ue= new Ulitity_Excel();
	String  cre=ue.select_Excel("Create C");
	driver.findElement(By.name("category")).sendKeys(cre);
	String  Desc=ue.select_Excel("Create description");
	driver.findElement(By.name("description")).sendKeys(Desc);
	Thread.sleep(1000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(text(),'Sub Category')]")).click();
	Thread.sleep(2000);
	WebElement drop = driver.findElement(By.cssSelector("select[name='category']"));
	
	Ulitity_Select ul=new Ulitity_Select();
	ul.select_option(drop,"Sports");
	Thread.sleep(2000);
	String  sub=ue.select_Excel("Sub Category");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(sub);
	Thread.sleep(2000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'Insert Product')]")).click();
	Thread.sleep(2000);
	WebElement drop1 = driver.findElement(By.name("category"));
	ul.select_option(drop1,"Sports");
	WebElement drop2 = driver.findElement(By.name("subcategory"));
	ul.select_option(drop2,"FootBall");
	driver.findElement(By.name("productName")).sendKeys(ue.select_Excel("Product name:"));
	Thread.sleep(1000);
	driver.findElement(By.name("productCompany")).sendKeys(ue.select_Excel("Product company:"));
	Thread.sleep(1000);
	driver.findElement(By.name("productpricebd")).sendKeys(ue.select_Excel("Product Price before discount:"));
	Thread.sleep(1000);
	driver.findElement(By.name("productprice")).sendKeys(ue.select_Excel("Product Price after discount"));
	Thread.sleep(1000);
	driver.findElement(By.name("productShippingcharge")).sendKeys(ue.select_Excel("Product Shipping charge: 0"));
	Thread.sleep(1000);
	WebElement drop3 = driver.findElement(By.name("productAvailability"));
	ul.select_option(drop3,"In Stock");
	Thread.sleep(1000);
	driver.findElement(By.name("productimage1")).sendKeys(ue.select_Excel("image"));
	Thread.sleep(1000);
	driver.findElement(By.name("productimage2")).sendKeys(ue.select_Excel("image"));
	Thread.sleep(1000);
	//driver.findElement(By.name("productimage3")).sendKeys(ue.select_Excel("image"));
	//Thread.sleep(1000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@class='nav-user dropdown open']/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	Thread.sleep(1000);
	driver.get(URL2);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("exampleInputEmail1")).sendKeys(USER1);
	driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASS1);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(ue.select_Excel("Product name:"));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@class='search-button']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
	Thread.sleep(1000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(text(),'Track')]")).click();
	Thread.sleep(1000);
	WebdriverUtility wl = new WebdriverUtility();
	wl.switchWindow(driver, "http://rmgtestingserver/domain/Online_Shopping_Application/order-history.php");
	Thread.sleep(2000);
	driver.findElement(By.linkText("Logout")).click();
}
}
