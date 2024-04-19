package com.GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class WebDriverUtility 
{
	//maximize
	public void maximizebroswer(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	//minimize
	public void minimizebroswer(WebDriver driver)
	{
		driver.manage().window().minimize();
	}



	//implicitwait 
	public void waitPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}



	//explicitwait
	public WebDriverWait waitExplicitwait(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}


	//visible of element
	public void waitUntilVisible(WebDriver driver,int sec,WebElement element)
	{
		waitExplicitwait(driver,sec).until(ExpectedConditions.visibilityOf(element));
	}


	//element is clickable
	public void waitUntilElementClickable(WebDriver driver,int sec,WebElement element)
	{
		waitExplicitwait(driver,sec).until(ExpectedConditions.elementToBeClickable(element));
	}


	//titleContains
	public void waitUntilTittle(WebDriver driver,int sec,String tittle)
	{
		waitExplicitwait(driver,sec).until(ExpectedConditions.titleContains(tittle));
	}

	//switchToWindow
	public void switchToWindow(WebDriver driver,String Expdata)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			String currentTittle = driver.switchTo().window(win).getTitle();
			if(currentTittle.contains(Expdata))
			{
				break;
			}
		}
	}

	//JavascriptExecutor
	public JavascriptExecutor javascript_reference(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	//send the value
	public void passData(WebDriver driver,String data,WebElement element)
	{ 
		javascript_reference(driver).executeScript("arguments[0].value='"+data+"'", element);

	}

	// click the disable element
	public void clickElement(WebDriver driver,WebElement element)
	{
		javascript_reference(driver).executeScript("arguments[0].click();", element);

	}

	//scroll to particular element
	public void scrolltoElement(WebDriver driver,WebElement element)
	{
		javascript_reference(driver).executeScript("arguments[0].scrollIntoView()", element);

	}

	//launch the url
	public void launchURL(WebDriver driver,String url)
	{
		javascript_reference(driver).executeScript("window.location=arguments[0]", url);

	}


	//scrolltoBottom
	public void scrolltoBottom(WebDriver driver)
	{
		javascript_reference(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	//scrolltoUp
	public void scrolltoUp(WebDriver driver)
	{
		javascript_reference(driver).executeScript("window.scrollBy(0,-document.body.scrollHeight)");

	}

	//locationofElement
	public void locationofElement(WebDriver driver,WebElement ele)
	{
		Point loc = ele.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		javascript_reference(driver).executeScript("window.scrollBy("+x+","+y+")"); 
	}
	
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		int y = element.getLocation().getY();
		javascript_reference(driver).executeScript("window.scrollBy(0,"+y+")", element);
	}


	//DropDown
	public  void dropDown(WebElement element,Object data)
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
	public List<WebElement> get_option(WebElement element)
	{
		List<WebElement> options = new Select(element).getOptions();
		return options;
	}


	//mouseAction
	public Actions mouseAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}

	//mouse_hover
	public void mouse_hover(WebDriver driver, WebElement element) 
	{
		mouseAction(driver).moveToElement(element).click().perform();
	}

	//double_click
	public void double_click(WebDriver driver, WebElement element) 
	{
		mouseAction(driver).doubleClick(element).perform();
	}

	//right_click
	public void rightClick(WebDriver driver, WebElement element) 
	{
		mouseAction(driver).contextClick(element).perform();
	}

	//drag_and_drop
	public void dragandDrop(WebDriver driver, WebElement source, WebElement dest)
	{
		mouseAction(driver).dragAndDrop(source, dest).perform();
	}

	//Senddata
	public void sendData(WebDriver driver, WebElement element,String data) 
	{
		mouseAction(driver).sendKeys(element,data).perform();
	}

	//scrollToElement
	public void scrollToElement(WebDriver driver, WebElement element) 
	{
		mouseAction(driver).scrollToElement(element).perform();
	}

	
	//TakesScreenShot
	/**This method will take screenshot and store it in a folder called as Screenshot
	 * @param driver
	 * @param screenShotName
	 * @param Throwable
	 * @throws Throwable 
	 */
	public static String getScreenShot(WebDriver sdriver,String screenShotName) throws Throwable
	{
		JavaUtility jutlis=new JavaUtility();
		TakesScreenshot ts= (TakesScreenshot)sdriver;
		String path="./screenshot/"+screenShotName+" "+jutlis.getSystemDateInFormat()+".png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(path);
		String scrpath = dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return scrpath;

	}
	
	//PressEnterKey
		/**This method will press enter key
		 * @param driver
		 */
		public void enterKeyPress(WebDriver driver)
		{
			mouseAction(driver).sendKeys(Keys.ENTER).perform();
		}
 

	/**This method will  press enter key
	 * @throws AWTException 
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}


	/**This method is to release the key
	 * @throws AWTException 
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/**This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

	/**This method will switch the frame based on name or id
	 * @param driver
	 * @param nameOrid
	 */
	public void switchToFrame1(WebDriver driver,String nameOrid)
	{
		driver.switchTo().frame(nameOrid);
	}

	/**This method will switch the frame based on name or id
	 * @param driver
	 * @param address
	 */
	public void switchToFrame2(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}

	/**This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	/**This method will senddata the alert popup
	 * @param driver
	 */
	public void SendkeyAlert(WebDriver driver,String data)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(data);
		alt.accept();
	}

	/**This method will GetText the alert popup
	 * @param driver
	 */
	public void getTextAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.getText();
		alt.accept();
	}
	
	/**This method will notification popup
	 * @param driver
	 * @return 
	 */
	public ChromeOptions handleNotificationBychromeOption()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		return option;
	}
	
}

