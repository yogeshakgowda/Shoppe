package com.EasyWhiz.ObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertProductPage {
	@FindBy(name="category")
	private WebElement createDropdown;

	@FindBy(name="subcategory")
	private WebElement subCategoryDdrop;

	@FindBy(name="productName")
	private WebElement productNameTxtFd;

	@FindBy(name="productCompany")
	private WebElement productCompanyFd;

	@FindBy(name="productpricebd")
	private WebElement productpricebdTxt;

	@FindBy(name="productprice")
	private WebElement productpriceTxt;

	@FindBy(name="productShippingcharge")
	private WebElement productShippingchargeTxt;

	@FindBy(name="productDescription")
	private WebElement productDescriptionTxt;

	@FindBy(name="productAvailability")
	private WebElement productAvailabilityDrop;

	@FindBy(name="productimage1")
	private WebElement productimage1btn;

	@FindBy(name="productimage2")
	private WebElement productimage2Btn;

	@FindBy(name="productimage3")
	private WebElement productimage3Btn;

	@FindBy(name="submit")
	private WebElement submitBtn;

	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateDropdown() {
		return createDropdown;
	}

	public WebElement getSubCategoryDdrop() {
		return subCategoryDdrop;
	}

	public WebElement getProductNameTxtFd() {
		return productNameTxtFd;
	}

	public WebElement getProductCompanyFd() {
		return productCompanyFd;
	}

	public WebElement getProductpricebdTxt() {
		return productpricebdTxt;
	}

	public WebElement getProductpriceTxt() {
		return productpriceTxt;
	}

	public WebElement getProductShippingchargeTxt() {
		return productShippingchargeTxt;
	}

	public WebElement getProductDescriptionTxt() {
		return productDescriptionTxt;
	}

	public WebElement getProductAvailabilityDrop() {
		return productAvailabilityDrop;
	}

	public WebElement getProductimage1btn() {
		return productimage1btn;
	}

	public WebElement getProductimage2Btn() {
		return productimage2Btn;
	}

	public WebElement getProductimage3Btn() {
		return productimage3Btn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	//Business libraries
	public void enterIntoInsertproduct(String Pname,String Pcname,String Pbd,String Pad,String Sch,String img,String imag)
	{
		productNameTxtFd.sendKeys(Pname);
		productCompanyFd.sendKeys(Pcname);
		productpricebdTxt.sendKeys(Pbd);
		productpriceTxt.sendKeys(Pad);
		productShippingchargeTxt.sendKeys(Sch);
		productimage1btn.sendKeys(img);
		productimage2Btn.sendKeys(imag);
		submitBtn.click();
	}


}
