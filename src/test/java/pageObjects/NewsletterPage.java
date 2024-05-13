package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterPage extends BasePage {
	
	public NewsletterPage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@value='1']")
	WebElement rdoYes;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement rdoNo;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement btnBack;
	
	@FindBy(xpath="//h1[normalize-space()='Newsletter Subscription']")
	WebElement textNewsletter;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msgSuccessNewletter;

	
	public void clickRdoYes() {
		rdoYes.click();
	}
	
	public void clickRdoNo() {
		rdoNo.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public void clickBack() {
		btnBack.click();
	}
	
	public String getTextNewsletter() {
		return textNewsletter.getText();
	}
	public String getMsgSuccessNewsletter() {
		return msgSuccessNewletter.getText();
	}
}
