package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearchPage extends BasePage{        //used when a product is searched from the search function
	
	public ProductSearchPage(WebDriver driver)
	{
	super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Products meeting the search criteria']")
	WebElement searchText;
	
	public boolean isSearchPageExists()
	{
		try {
			
			 return searchText.isDisplayed();
		}
		catch(Exception e){
			return (false);
		}
	}
}
