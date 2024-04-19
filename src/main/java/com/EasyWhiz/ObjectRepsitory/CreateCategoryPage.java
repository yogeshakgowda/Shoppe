package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {
	@FindBy(name="category")
	private WebElement categoryNameTxtFd;

	@FindBy(name="description")
	private WebElement descriptionTxtFd;

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
	


	public CreateCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getCategoryNameTxtFd() {
		return categoryNameTxtFd;
	}


	public WebElement getDescriptionTxtFd() {
		return descriptionTxtFd;
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


	public WebElement getDeleteIcon() {
		return deleteIcon;
	}

	//Business libraries
		public void enterIntoCreateCategory(String Cname,String Ddetails) throws InterruptedException
		{
			categoryNameTxtFd.sendKeys(Cname);
			descriptionTxtFd.sendKeys(Ddetails);
			Thread.sleep(3000);
			submitBtn.click();
		}
}
