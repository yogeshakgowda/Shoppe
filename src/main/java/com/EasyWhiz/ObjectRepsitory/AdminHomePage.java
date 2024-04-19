package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage 
{
	@FindBy(css = "a[href='#togglePages']")
	private WebElement ordermanagamentlink;

	@FindBy(css = "a[href='manage-users.php']")
	private WebElement manageUserlink;

	@FindBy(css = "a[href='category.php']")
	private WebElement createCatlink;

	@FindBy(css = "a[href='subcategory.php']")
	private WebElement subCreatelink;

	@FindBy(css = "a[href='insert-product.php']")
	private WebElement insertProductlink;

	@FindBy(css = "a[href='manage-products.php']")
	private WebElement manageProductlink;

	@FindBy(linkText = "Logout")
	private WebElement logoulink;
	
	@FindBy(css = "a[href='todays-orders.php']")
	private WebElement OrderToady;
	
	
	//Initialization
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	
	public WebElement getOrdermanagamentlink() {
		return ordermanagamentlink;
	}
	public WebElement getOrderToady() {
		return OrderToady;
	}

	public WebElement getManageUserlink() {
		return manageUserlink;
	}
	public WebElement getCreateCatlink() {
		return createCatlink;
	}
	public WebElement getSubCreatelink() {
		return subCreatelink;
	}
	public WebElement getInsertProductlink() {
		return insertProductlink;
	}
	public WebElement getManageProductlink() {
		return manageProductlink;
	}
	public WebElement getLogoulink() {
		return logoulink;
	}
	
	
	//Business libraries
	public void clickonOrdermanagament()
	{
		ordermanagamentlink.click();
	}
	
	public void clickonManageUser()
	{
		manageUserlink.click();
	}
	
	public void clickonCreateCategory()
	{
		createCatlink.click();
	}
	public void clickonSubCreate()
	{
		subCreatelink.click();
	}
	public void clickoninsertProduct()
	{
		insertProductlink.click();
	}
	public void clickonManageProduct()
	{
		manageProductlink.click();
	}
	public void clickonLogout()
	{
		logoulink.click();
	}
}
