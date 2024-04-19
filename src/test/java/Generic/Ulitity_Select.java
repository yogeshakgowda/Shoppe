 package Generic;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ulitity_Select {
	public static void select_option(WebElement element,Object data)
	{
		Select sel =new Select(element);
		if(data instanceof Integer)
		{
			sel.selectByIndex((Integer) data);
		}
		else if(data instanceof String)
		{
			try
			{
				sel.selectByValue((String) data);
			}
			catch(Exception e)
			{
				sel.selectByVisibleText((String) data);
			}
		}
	}
	public static List<WebElement> get_option(WebElement element)
	{
		List<WebElement> options = new Select(element).getOptions();
		return options;
	}
}
