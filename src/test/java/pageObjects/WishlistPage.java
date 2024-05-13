package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BasePage{
	
	public WishlistPage (WebDriver driver)
	{
		super(driver);
	}
	WebDriverWait w = new WebDriverWait(super.driver,Duration.ofSeconds(10));

	@FindBy(xpath="//button[@data-original-title='Add to Cart']")
	WebElement btnAddtoCart;
	
	@FindBy(xpath="//a[@data-original-title='Remove']")
	WebElement btnDelete;
	
	@FindBy(xpath="//div[@class='pull-right']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement textModify;
	
	@FindBy(xpath="//p[normalize-space()='Your wish list is empty.']")
	WebElement textEmpty;
	
	public void clickAddtoCart() {
		w.until(ExpectedConditions.elementToBeClickable(btnAddtoCart)).click();
	}
	public void clickDelete() {
		w.until(ExpectedConditions.elementToBeClickable(btnDelete)).click();
	}
	public void clickContinue()
	{
		w.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	public String getTextModify() {
		return textModify.getText();
		
	}
	public String getTextEmpty() {
		return textEmpty.getText();
	}
}
