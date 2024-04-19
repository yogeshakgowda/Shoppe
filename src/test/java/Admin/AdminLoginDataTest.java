package Admin;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepsitory.AdminLoginPage;
import com.GenericUtilities.GenericDataProvider;
import com.GenericUtilities.WebDriverUtility;

public class AdminLoginDataTest {
	@Test(dataProvider = "Data", dataProviderClass = GenericDataProvider.class)
	public void getData(String name,String pass) throws InterruptedException
	{
		WebDriverUtility gwebdri = new WebDriverUtility();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/ADMIN/");
		gwebdri.waitPageLoad(driver, 20);
		AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
		adminLoginPage.loginToApp(name, pass);
		//driver.close();
		//hello
		
		System.out.println("hello");
	}
}
