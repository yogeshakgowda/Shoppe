package Generic;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebdriverUtility {
public void switchWindow(WebDriver driver,String url)
{
	Set<String> wid = driver.getWindowHandles();
	for(String str:wid)
	{
		driver.switchTo().window(str);
		String text = driver.getCurrentUrl();
		if(text.contains(url))
		{
			break;
		}
	}
}
}
