package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
	super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]")
	WebElement btnTablets;
	
	@FindBy(xpath="//a[normalize-space()='Password']")
	WebElement tabPassword;
	
	@FindBy(xpath="//a[normalize-space()='Edit Account']")
	WebElement tabMyaccnt;
	
	@FindBy(xpath="//a[normalize-space()='Address Book']")
	WebElement tabAddressBook;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Wish List']")
	WebElement tabWishlist;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']")
	WebElement tabNewsletter;
	
	public boolean isMyAccountPageExists()
	{
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	public void clickTablets() {
		btnTablets.click();
	}
	
	public void clickPassword() {
		tabPassword.click();
	}
	
	public void clickMyAccount() {
		tabMyaccnt.click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickAddressBook() {
		tabAddressBook.click();
	}
	
	public void clickWishlist()
	{
		tabWishlist.click();
	}
	
	public void clickNewsletter() {
		tabNewsletter.click();
	}
}
