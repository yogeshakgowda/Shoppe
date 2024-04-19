package User;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AdminAndUserLoginTest {
	public static WebDriver driver;
	@Test
	public void script() throws InterruptedException, IOException
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
	Thread.sleep(2000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[@class='nav-user dropdown open']/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	Thread.sleep(1000);
	driver.get(URL2);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("exampleInputEmail1")).sendKeys(USER1);
	driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASS1);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Logout")).click();
	//driver.quit();
	}
}
