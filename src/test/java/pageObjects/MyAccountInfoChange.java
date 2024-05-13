package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountInfoChange extends BasePage{
	
	public MyAccountInfoChange (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement tp;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement textAccchange;
	
	//Password Change Page
	
	@FindBy(xpath="//input[@id='input-password']")         //Change password feature
	WebElement pwdchange;
	
	@FindBy(xpath="//input[@id='input-confirm']")        
	WebElement newpwdchange;
	
	@FindBy(xpath="//input[@value='Continue']")       
	WebElement btnpw;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")       
	WebElement textPswdChange;
	
	public void typeFname(String firstn)
	{
		fname.clear();
		fname.sendKeys(firstn);
	}
	
	public void typeLname(String lastn)
	{
		lname.clear();
		lname.sendKeys(lastn);
	}
	
	public void typeEmail(String e)
	{
		email.clear();
		email.sendKeys(e);
	}
	
	public void typeTp(String tele)
	{
		tp.clear();
		tp.sendKeys(tele);
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getTextAccntChange()
	{
		return textAccchange.getText();
	}
	
	public void typePassword(String pw)
	{
		pwdchange.sendKeys(pw);
	}
	
	public void typeNewPasswrod(String newpw)
	{
		newpwdchange.sendKeys(newpw);
	}	
	
	public void clickContPw()
	{
		btnpw.click();
	}	
	
	public String getTextPswdChange()
	{
		return textPswdChange.getText();
	}
	
}
