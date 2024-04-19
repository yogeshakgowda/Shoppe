package com.EasyWhiz.ObjectRepsitory;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLonginPage 
{
	@FindBy(id="fullname")
	private WebElement fullNameTxt;
	
	@FindBy(id="email")
	private WebElement emailTxt;
	
	@FindBy(id="contactno")
	private WebElement contactnoTxt;
	
	@FindBy(id="password")
	private WebElement passwordTxt;

	
	@FindBy(id="confirmpassword")
	private WebElement confirmpasswordTxt;
	
	@FindBy(id="submit")
	private WebElement SingupsubmitBtn;
	
	@FindBy(id="exampleInputEmail1")
	private WebElement LogemailTxtFd;

	@FindBy(id="exampleInputPassword1")
	private WebElement logPassTxt;
	

	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginBtn;

	public UserLonginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getFullNameTxt() {
		return fullNameTxt;
	}

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getContactnoTxt() {
		return contactnoTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getConfirmpasswordTxt() {
		return confirmpasswordTxt;
	}

	public WebElement getSingupsubmitBtn() {
		return SingupsubmitBtn;
	}

	public WebElement getLogemailTxtFd() {
		return LogemailTxtFd;
	}

	public WebElement getLogPassTxt() {
		return logPassTxt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void userloginToApp(String username,String password) throws InterruptedException
	{
		LogemailTxtFd.sendKeys(username);
		Thread.sleep(2000);
		logPassTxt.sendKeys(password);
		Thread.sleep(2000);
		loginBtn.click();
	}
	
	public void SignupAs(String full,String email,String con,String pass,String pass1) throws InterruptedException
	{
		fullNameTxt.sendKeys(full);
		Thread.sleep(2000);
		emailTxt.sendKeys(email);
		Thread.sleep(2000);
		contactnoTxt.sendKeys(con);
		Thread.sleep(2000);
		passwordTxt.sendKeys(pass);
		Thread.sleep(2000);
		confirmpasswordTxt.sendKeys(pass1);
		Thread.sleep(2000);
		SingupsubmitBtn.click();
		Thread.sleep(2000);
	}
	
}
