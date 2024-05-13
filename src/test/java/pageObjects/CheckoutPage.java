package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage{
		
		public CheckoutPage(WebDriver driver)
		{
			super(driver);
		}
	WebDriverWait w = new WebDriverWait(super.driver,Duration.ofSeconds(10));
		
	@FindBy(xpath="//input[@id='button-shipping-address']")
	WebElement btnContinue;
	
	@FindBy(xpath="	//input[@id='button-shipping-method']")
	WebElement btnContinue2;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chckPrivacy;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	WebElement btnContinue4;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement btnConfirmOrder;	
	
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
	WebElement textOrderSuccess;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement finalContinue;
	
	public void clickContinue()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='button-shipping-address']"))).click();
	}
	public void clickContinue2()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='button-shipping-method']"))).click();
	}
	public void clickChkPrivacy()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='agree']"))).click();
	}
	public void clickContinue4()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='button-payment-method']"))).click();
	}
	public void clickConfirmOrder()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='button-confirm']"))).click();
	}
	public String getTextConfirmOrder()
	{
		return textOrderSuccess.getText();
	}
	public void clickFinalContinue()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary']"))).click();
	}
	public void waitforAlertandAccept() {
		w.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
}
