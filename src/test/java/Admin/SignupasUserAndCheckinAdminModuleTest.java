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

import Generic.Ulitity_Excel;
import Generic.WebdriverUtility;

public class SignupasUserAndCheckinAdminModuleTest {
	WebDriver driver=null;
	@Test
	public void testScript() throws InterruptedException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Common.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL2 = pobj.getProperty("urlU");
		String USER = pobj.getProperty("username");
		String PASS = pobj.getProperty("password");
		
		String URL1 = pobj.getProperty("urlA");
		String USER1 = pobj.getProperty("EmailAdd");
		String PASS1 = pobj.getProperty("cpass");
		
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
		driver.get(URL2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(2000);
		
        Ulitity_Excel ue= new Ulitity_Excel();
		driver.findElement(By.id("fullname")).sendKeys(ue.select_Excel1("FullName"));
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(ue.select_Excel1("EmailAdd"));
		Thread.sleep(1000);
		driver.findElement(By.id("contactno")).sendKeys(ue.select_Excel1("contact"));
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(ue.select_Excel1("pass"));
		Thread.sleep(1000);
		driver.findElement(By.id("confirmpassword")).sendKeys(ue.select_Excel1("pass"));
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USER1);
		Thread.sleep(1000);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(ue.select_Excel1("pass"));
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
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(ue.select_Excel1("FullName"));
		driver.findElement(By.xpath("//li[@class='nav-user dropdown open']/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(1000);
	}
}
