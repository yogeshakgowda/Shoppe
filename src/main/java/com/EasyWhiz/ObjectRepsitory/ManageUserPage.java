package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUserPage {
	@FindBy(css="input[aria-controls='DataTables_Table_0']")
	private WebElement searchTxtFd;
  
	@FindBy(name="DataTables_Table_0_length")
	private WebElement dropDownTxt;
	
	public ManageUserPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getSearchTxtFd() {
		return searchTxtFd;
	}

	public WebElement getDropDownTxt() {
		return dropDownTxt;
	}
	
	
	public void manageUserUpdate(String Pname)
	{
		searchTxtFd.sendKeys(Pname);
	}

	
}
