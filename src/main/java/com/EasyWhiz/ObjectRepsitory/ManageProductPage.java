package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
	@FindBy(name="submit")
	private WebElement submitBtn;

	@FindBy(css="input[aria-controls='DataTables_Table_0']")
	private WebElement searchTxtFd;
  
	@FindBy(name="DataTables_Table_0_length")
	private WebElement dropDownTxt;
	
	@FindBy(css="i[class='icon-edit']")
	private WebElement editIcon;
	
	@FindBy(css="i[class='icon-remove-sign']")
	private WebElement deleteIcon;
	
	@FindBy(name="productShippingcharge")
	private WebElement ProductShipping;
	

	public ManageProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}



	public WebElement getSubmitBtn() {
		return submitBtn;
	}



	public WebElement getSearchTxtFd() {
		return searchTxtFd;
	}



	public WebElement getDropDownTxt() {
		return dropDownTxt;
	}



	public WebElement getEditIcon() {
		return editIcon;
	}



	public WebElement getProductShipping() {
		return ProductShipping;
	}



	public WebElement getDeleteIcon() {
		return deleteIcon;
	}
	
	public void manageProductUpdate(String Pname)
	{
		searchTxtFd.sendKeys(Pname);
		editIcon.click();
		ProductShipping.sendKeys("45");
		submitBtn.click();
	}


}
