package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage 
{
	//Declaretion
	@FindBy(name = "username")
	private WebElement usernameTxtFd;

	@FindBy(name = "password")
	private WebElement PasswordTxtFd;


	@FindBy(name = "submit")
	private WebElement loginBtn;

	//Initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUsernameTxtFd() {
		return usernameTxtFd;
	}

	public WebElement getPasswordTxtFd() {
		return PasswordTxtFd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Business libraries
		/**
		 * login to application with username and password and click on save btn
		 * @param username
		 * @param password
		 */
		public void loginToApp(String username,String password)
		{
			usernameTxtFd.sendKeys(username);
			PasswordTxtFd.sendKeys(password);
			loginBtn.click();
		}
}
