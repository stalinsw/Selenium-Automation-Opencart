package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage extends BasePage{
	
	public AddressBookPage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='btn btn-info']")
	WebElement btnEdit;
	
	@FindBy(xpath="//tbody/tr[2]/td[2]/a[2]")
	WebElement btnDel;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnNewAddress;
	
	@FindBy(xpath="//h2[normalize-space()='Address Book Entries']")
	WebElement txtAddress;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fieldFname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement fieldLname;
	
	@FindBy(xpath="//input[@id='input-company']")
	WebElement fieldCom;
	
	@FindBy(xpath="//input[@id='input-address-1']")
	WebElement fieldAd1;
	
	@FindBy(xpath="//input[@id='input-address-2']")
	WebElement fieldAd2;
	
	@FindBy(xpath="//input[@id='input-city']")
	WebElement fieldCity;
	
	@FindBy(xpath="//input[@id='input-postcode']")
	WebElement fieldPost;
	
	@FindBy(xpath="//select[@id='input-country']")
	WebElement drpCountry;
	
		@FindBy(xpath="//option[text()='New Zealand']")
		WebElement txtCountry;
	
	@FindBy(xpath="//select[@id='input-zone']")
	WebElement drpRegion;
	
	@FindBy(xpath="//input[@value='1']")
	WebElement rdoDefault;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msgNewAdd;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msgDelete;
	
	@FindBy(xpath="//div[@class='alert alert-warning']")
	WebElement msgWarning;
	
	public void clickNewAddress()
	{
		btnNewAddress.click();
	}
	
	public void clickDel()
	{
        btnDel.click();
	}
	
	public void typeFname(String firstname)
	{
		fieldFname.sendKeys(firstname);
	}
	
	public void typeLname(String lastname)
	{
		fieldLname.sendKeys(lastname);
	}
	
	public void typeCom(String com)
	{
		fieldCom.sendKeys(com);
	}
	
	public void typeAddress1(String ad1)
	{
		fieldAd1.sendKeys(ad1);
	}
	
	public void typeAddress2(String ad2)
	{
		fieldAd2.sendKeys(ad2);
	}
	
	public void typeCity(String city)
	{
		fieldCity.sendKeys(city);
	}
	
	public void typePost(String post)
	{
		fieldPost.sendKeys(post);
	}
	
	public void clickCountrydrp()
	{
		drpCountry.click();
		txtCountry.click();
	}
	
	public void clickRegiondrp()
	{
		Select s = new Select(drpRegion);
		s.selectByVisibleText("Otago");
	}
	
	public void clickRdo()
	{
		rdoDefault.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getMsgAdd()
	{
		return msgNewAdd.getText();
	}
	
	public String getMsgDelete()
	{
		return msgDelete.getText();
	}
	
	public String getMsgWarning() {
		return msgWarning.getText();
	}
}