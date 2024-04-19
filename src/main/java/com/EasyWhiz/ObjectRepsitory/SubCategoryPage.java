package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage {
	@FindBy(css="select[name='category']")
	private WebElement createDropdown;

	@FindBy(xpath="//input[@placeholder='Enter SubCategory Name']")
	private WebElement subCategoryName;

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



	public SubCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}



	public WebElement getCreateDropdown() {
		return createDropdown;
	}



	public WebElement getSubCategoryName() {
		return subCategoryName;
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
	public void enterIntosubCategory(String Ddetails)
	{
		subCategoryName.sendKeys(Ddetails);
		submitBtn.click();
	}
}
