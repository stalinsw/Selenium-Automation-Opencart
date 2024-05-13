package pageObjects;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CameraProductPage extends BasePage{
	
	public CameraProductPage(WebDriver driver)
	{
		super(driver);
	}
	WebDriverWait w = new WebDriverWait(super.driver,Duration.ofSeconds(10));
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement fieldQuantity;
	
	@FindBy(xpath="//select[@id='input-option226']")
	WebElement drpdwnColour;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnAddtoCart;
	
	@FindBy(xpath="//h1[normalize-space()='Canon EOS 5D']")
	WebElement textCamera;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']")
	WebElement btnWishlist;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement textWishlist;
	
	public void typeQuantity(String quantity)
	{
		fieldQuantity.clear();
		fieldQuantity.sendKeys(quantity);
	}
	public void clickAddToCart()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='button-cart']"))).click();
	}
	public void clickDropdown()
	{
		Select s = new Select(drpdwnColour);
		s.selectByIndex(1);
		
	}
	public String getProductText() {
		return textCamera.getText(); 
	}
	public void clickWishlist() {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']//i[@class='fa fa-heart']"))).click();
	}
	public String getWishlistText() {
		return textWishlist.getText();
	}
	public boolean isExistAddtoCart() {
		
		return btnAddtoCart.isDisplayed();
	}
}
