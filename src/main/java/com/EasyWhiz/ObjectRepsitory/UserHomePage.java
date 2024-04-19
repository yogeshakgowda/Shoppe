package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage 
{
	@FindBy(xpath="//a[text()='Login']")
	private WebElement LoginLink;

	@FindBy(xpath="//input[@class='search-field']")
	private WebElement SearchTxtFd;
	

	@FindBy(xpath="//button[@class='search-button']")
	private WebElement SearchBtn;

	@FindBy(css="a[href='my-cart.php']")
	private WebElement myCartlink;

	@FindBy(css="a[href='my-wishlist.php']")
	private WebElement myWishlistlink;

	@FindBy(css="a[href='my-account.php']")
	private WebElement myAccount;

	@FindBy(xpath="//span[.='Track Order']")
	private WebElement TrackOrderBtn;

	@FindBy(xpath="//a[@href='index.php' and @data-hover='dropdown']")
	private WebElement HomeTab;

	@FindBy(linkText = "Logout")
	private WebElement logoulink;
	
	
	@FindBy(css = "button[class='btn btn-primary']")
	private WebElement AddtoCartBtn;
	
	@FindBy(css = "i[class='icon fa fa-heart']")
	private WebElement AddToWishlist;
	
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getLoginLink() {
		return LoginLink;
	}


	public WebElement getSearchTxtFd() {
		return SearchTxtFd;
	}


	public WebElement getSearchBtn() {
		return SearchBtn;
	}


	public WebElement getMyCartlink() {
		return myCartlink;
	}


	public WebElement getMyWishlistlink() {
		return myWishlistlink;
	}


	public WebElement getMyAccount() {
		return myAccount;
	}


	public WebElement getTrackOrderBtn() {
		return TrackOrderBtn;
	}


	public WebElement getHomeTab() {
		return HomeTab;
	}


	public WebElement getLogoulink() {
		return logoulink;
	}
	
	
	public WebElement getAddtoCartBtn() {
		return AddtoCartBtn;
	}


	public WebElement getAddToWishlist() {
		return AddToWishlist;
	}


	public void SearchProduct(String Product) throws InterruptedException
	{
		SearchTxtFd.sendKeys(Product);
		Thread.sleep(1000);
		SearchBtn.click();
		AddtoCartBtn.click();
	}
	
	public void logoutFromPage()
	{
		logoulink.click();
	}
	
	public void ClickOnMyAccount()
	{
		myAccount.click();
	}
	
	public void ClickOnLogin()
	{
		LoginLink.click();
	}
	
}
