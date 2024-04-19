package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy(name="ordersubmit")
	private WebElement CheckOutBtn;

	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCheckOutBtn() {
		return CheckOutBtn;
	}
	
	
	
	public void orderProduct()
	{
		CheckOutBtn.click();
	}
}
