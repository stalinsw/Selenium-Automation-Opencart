package pageObjects;          //Page used when we search camera, and all the camera products are listed

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListPage extends BasePage{
	
	public ProductListPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'Canon EOS 5D')]")
	WebElement itemCamera;
	
	public void clickItemCamera() {
		
		WebDriverWait w = new WebDriverWait(super.driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='caption']//a[contains(text(),'Canon EOS 5D')]"))).click();
	}
	
	public String getTextCamera() {
		return itemCamera.getText();	
		}
}
