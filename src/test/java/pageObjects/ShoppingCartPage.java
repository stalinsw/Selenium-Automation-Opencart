package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage{
	
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	WebDriverWait w = new WebDriverWait(super.driver,Duration.ofSeconds(10));
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnCheckout;
	
	@FindBy(xpath="	//input[@id='input-payment-firstname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='input-payment-company']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	WebElement addr1;
	
	@FindBy(xpath="	//input[@id='input-payment-address-2']")
	WebElement addr2;
	
	@FindBy(xpath="	//input[@id='input-payment-city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	WebElement postcode;
	
	@FindBy(xpath="	//select[@id='input-payment-country']")
	WebElement country;
	
		@FindBy(xpath="//option[@value='13']")  //Australia
		WebElement aus;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	WebElement region;

	@FindBy(xpath="//input[@id='button-payment-address']")
	WebElement btnCheckout2;
	
		
	public void clickCheckout()
	{
		btnCheckout.click();
	}
	
	public void typeFname(String firstname)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-payment-firstname']"))).sendKeys(firstname);
	}
	public void typeLname(String lastname)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-payment-lastname']"))).sendKeys(lastname);
	}
	public void typeCompany(String com)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-payment-company']"))).sendKeys(com);
	}
	public void typeaddress1(String ad1)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-payment-address-1']"))).sendKeys(ad1);
	}
	public void typeaddress2(String ad2)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-payment-address-2']"))).sendKeys(ad2);
	}
	public void typeCity(String c)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-payment-city']"))).sendKeys(c);
	}
	public void typePost(String pc)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-payment-postcode']"))).sendKeys(pc);
	}
	public void drpCountry()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='input-payment-country']"))).click();
		aus.click();
	}
	public void drpRegion()
	{
		Select select = new Select(region);
		select.selectByVisibleText("Queensland");
	}
	public void clickCheckout2()
	{
		btnCheckout2.click();
	}
	
}






