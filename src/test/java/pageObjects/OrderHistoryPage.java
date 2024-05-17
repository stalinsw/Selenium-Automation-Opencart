package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistoryPage extends BasePage {
	
	public OrderHistoryPage(WebDriver driver)
	{
		super(driver);
	}	
	
	WebDriverWait wait = new WebDriverWait(super.driver,Duration.ofSeconds(10));
	
	@FindBy(xpath="//h1[normalize-space()='Order History']")
	WebElement txtOrderHistory;
	
	
	@FindBy(
	xpath="//table[@class='table table-bordered table-hover']//descendant::tr[2]//td[2]")
	WebElement txtCustomername;
	
	
	@FindBy(xpath="//td[normalize-space()='$245.00']")
	WebElement txtPrice;
	
	@FindBy(xpath="//tbody/tr[1]/td[7]/a[1]")
	WebElement btnView;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement txtProductName;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement btnReturn;
	
	public void clickReturn() {
		btnReturn.click();
	}
	public String getProductName() {
		return txtProductName.getText();
	}
	public void clickView() {
		btnView.click();
	}
	public String getPrice() {
		return txtPrice.getText();	
	}
	
	public String getCustomerName() {
		return txtCustomername.getText(); 
		}
	
	public String getTextOrderHistory() {
		return txtOrderHistory.getText();
	}

}
