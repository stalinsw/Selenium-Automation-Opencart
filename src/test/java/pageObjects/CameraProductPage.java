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
	
	@FindBy(xpath="//a[normalize-space()='Write a review']")
	WebElement txtWriteReview;
	
	@FindBy(xpath="//input[@id='input-name']")
	WebElement txtReviewName;
	
	@FindBy(xpath="//textarea[@id='input-review']")
	WebElement txtReview;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msgReviewSuccess;
	
	@FindBy(xpath="//input[@value='4']")
	WebElement bltReview;
	
	@FindBy(xpath="//button[@id='button-review']")
	WebElement btnReviewContinue;
	
	@FindBy(xpath="//h2[normalize-space()='$80.00']")
	WebElement txtPriceCamera;

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
	public void clickWriteReview() {
		txtWriteReview.click();
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
	public void typeReviewName(String name) {
		txtReviewName.sendKeys(name);
	}
	public void typeReview(String text) {
		txtReview.sendKeys(text);
	}
	public void clickBltReview() {
		bltReview.click();
	}
	public void clickReviewContinue() {
		btnReviewContinue.click();
	}
	public String getMsgSuccessReview() {
		return msgReviewSuccess.getText();
	}
	public String getTextPrice() {
		return txtPriceCamera.getText();
	}
}
