package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 
{
	@FindBy(xpath="//a[@href='my-account.php']")
	private WebElement MyAccountlink;
	
	@FindBy(xpath="//a[@href='order-history.php']")
	private WebElement orderHistorylink;
	
	@FindBy(xpath="//a[@href='pending-orders.php']")
	private WebElement PaymentPendingOrderlink;
	
	@FindBy(xpath="//a[@href='bill-ship-addresses.php']")
	private WebElement shippingAndBillinglink;

	@FindBy(xpath="//textarea[@name='billingaddress']")
	private WebElement billingaddress;
	
	@FindBy(id="bilingstate")
	private WebElement bilingstateTxt;

	@FindBy(id="billingcity")
	private WebElement billingcityTxt;
	
	@FindBy(id="billingpincode")
	private WebElement billingpincodeTxt;

	@FindBy(xpath="//form[@class='register-form']//descendant::button[@name='update']")
	private WebElement BillingUpdateBtn;
	
	@FindBy(xpath="//a[@href='#collapseTwo']")
	private WebElement shippinglink;

	@FindBy(xpath="//textarea[@name='shippingaddress']")
	private WebElement shippingingaddress;
	
	@FindBy(id="shippingstate")
	private WebElement shippingingstateTxt;

	@FindBy(id="shippingcity")
	private WebElement shippingcityTxt;
	
	@FindBy(id="shippingpincode")
	private WebElement shippingpincodeTxt;

	@FindBy(xpath="//form[@class='register-form']//descendant::button[@name='shipupdate']")
	private WebElement shippingUpdateBtn;

	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getMyAccountlink() {
		return MyAccountlink;
	}

	public WebElement getOrderHistorylink() {
		return orderHistorylink;
	}

	public WebElement getPaymentPendingOrderlink() {
		return PaymentPendingOrderlink;
	}

	public WebElement getShippingAndBillinglink() {
		return shippingAndBillinglink;
	}

	public WebElement getBillingaddress() {
		return billingaddress;
	}

	public WebElement getBilingstateTxt() {
		return bilingstateTxt;
	}

	public WebElement getBillingcityTxt() {
		return billingcityTxt;
	}

	public WebElement getBillingpincodeTxt() {
		return billingpincodeTxt;
	}

	public WebElement getBillingUpdateBtn() {
		return BillingUpdateBtn;
	}

	public WebElement getShippinglink() {
		return shippinglink;
	}

	public WebElement getShippingingaddress() {
		return shippingingaddress;
	}

	public WebElement getShippingingstateTxt() {
		return shippingingstateTxt;
	}

	public WebElement getShippingcityTxt() {
		return shippingcityTxt;
	}

	public WebElement getShippingpincodeTxt() {
		return shippingpincodeTxt;
	}

	public WebElement getShippingUpdateBtn() {
		return shippingUpdateBtn;
	}
	
	public void BillingAddressUpdate(String full,String email,String con,String pass) throws InterruptedException
	{
		shippingAndBillinglink.click();
		Thread.sleep(2000);
		billingaddress.sendKeys(full);
		Thread.sleep(2000);
		bilingstateTxt.sendKeys(email);
		Thread.sleep(2000);
		billingcityTxt.sendKeys(con);
		Thread.sleep(2000);
		billingpincodeTxt.sendKeys(pass);
		Thread.sleep(2000);
		BillingUpdateBtn.click();
		Thread.sleep(2000);
	}
	
	public void ShippingAddressUpdate(String full,String email,String con,String pass) throws InterruptedException
	{
		shippinglink.click();
		Thread.sleep(2000);
		shippingingaddress.sendKeys(full);
		Thread.sleep(2000);
		shippingingstateTxt.sendKeys(email);
		Thread.sleep(2000);
		shippingcityTxt.sendKeys(con);
		Thread.sleep(2000);
		shippingpincodeTxt.sendKeys(pass);
		Thread.sleep(2000);
		shippingUpdateBtn.click();
		Thread.sleep(2000);
	}
}

