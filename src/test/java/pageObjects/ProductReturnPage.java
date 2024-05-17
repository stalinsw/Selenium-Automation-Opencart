package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductReturnPage extends BasePage {
	
WebDriver driver;
	
	public ProductReturnPage(WebDriver driver)
	{
		super(driver);
	}	
	
	WebDriverWait wait = new WebDriverWait(super.driver,Duration.ofSeconds(10));
	
	@FindBy(xpath="//h1[normalize-space()='Product Returns']")
	WebElement txtReturn;
	
	@FindBy(xpath="//input[@value='3']")
	WebElement rdoBtn;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//textarea[@id='input-comment']")
	WebElement txtArea;
	
	@FindBy(xpath="//p[contains(text(),'Thank you for submitting your return request. Your')]")
	WebElement txtSuccessReturn;
	
	public String getTextReturn() {
		return txtReturn.getText();
	}
	public void typeTextArea(String txt) {
		txtArea.sendKeys(txt);
	}
	public void clickSubmit() {
		btnSubmit.click();
	}
	public void rdoBtn() {
		rdoBtn.click();
	}
	public String getTextSuccessReturn() {
		return txtSuccessReturn.getText();
	}
	

	

}
