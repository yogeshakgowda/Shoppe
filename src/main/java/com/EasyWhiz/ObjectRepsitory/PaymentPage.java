package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	@FindBy(name="submit")
	private WebElement SubmitButton;

	public PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	
	
	public void orderProduct()
	{
		SubmitButton.click();
	}
}
