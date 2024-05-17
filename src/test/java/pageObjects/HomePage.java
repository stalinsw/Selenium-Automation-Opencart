package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}	
	
	WebDriverWait wait = new WebDriverWait(super.driver,Duration.ofSeconds(10));
	

	@FindBy(xpath="//a[normalize-space()='Desktops']")
	WebElement tabDesktop;
	
	@FindBy(xpath="	//a[normalize-space()='Components']")
	WebElement tabComponents;
	
	@FindBy(xpath="//a[normalize-space()='Tablets']")
	WebElement tabTablets;
	
	@FindBy(xpath="//a[normalize-space()='Software']")
	WebElement tabSoftwares;
	
	@FindBy(xpath="	//a[normalize-space()='Phones & PDAs']")
	WebElement tabPhonesPDAs;
	
	@FindBy(xpath="//a[normalize-space()='Cameras']")
	WebElement tabCameras;
	
	@FindBy(xpath="//a[normalize-space()='MP3 Players']")
	WebElement tabMP3Player;

	@FindBy (xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy (xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")   // Login link added in step5
	WebElement linkLogin;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	WebElement lnkShoppingcart;
	
	@FindBy(xpath="//a[@id='wishlist-total']")   //span[contains(text(),'Wish List')]
	WebElement lnkWishlist;
	
	@FindBy(xpath="//a[@title='Checkout']")
	WebElement lnkCheckout;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement btnCheckout;
	
	@FindBy(xpath="//span[normalize-space()='123456789']")
	WebElement txtPhoneno;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement fieldSearch;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[contains(text(),'test 21')]")          
	WebElement lnkTest21;
	
	@FindBy(xpath="//div[@class='carousel swiper-viewport']//div[@class='swiper-button-next']")
	WebElement btnCrslNext;
	
	@FindBy(xpath="//div[@class='carousel swiper-viewport']//div[@class='swiper-button-prev']")
	WebElement btnCrslPrev;
	
	@FindBy(xpath="//div[contains(@class,'swiper-pagination carousel')]//child::span")
	List <WebElement> bulletsCarousel;
	
	@FindBy(xpath="//div[@id='carousel0']//descendant::img")
	List <WebElement> elementCarousel;
	
	@FindBy(xpath="//div[@class='carousel swiper-viewport']")
	WebElement Carousel;
	
	@FindBy(xpath="//img[@title='Your Store']")
	WebElement btnHome;
	
	@FindBy(xpath="//div[@class='col-sm-3']//descendant::a")
	List <WebElement>  lnkFooter;
	
	@FindBy(xpath="//div[@class='col-sm-3']//descendant::h5")
	List<WebElement> lnkFooterHeading;
	
	@FindBy(xpath="//p[contains(text(),'Powered By')]")
	WebElement textFooterYearCompany;
	
	@FindBy(xpath="//div[@class='slideshow swiper-viewport']//div[@class='swiper-button-prev']")
	WebElement btncarouselMainPrev;
	
	@FindBy(xpath="//div[@class='slideshow swiper-viewport']//div[@class='swiper-button-next']")
	WebElement btncarouselMainNxt;
	
	@FindBy(xpath="//div[contains(@class,'swiper-pagination slideshow')]//child::span")
	List <WebElement> bulletCarouselMain;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Order History']")
	WebElement lnkOrderHistory;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']")
	WebElement lnkMyAccountDrp;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void clickLogin()
	{
		linkLogin.click();
	}
	public void clickShoppingCart()
	{
		lnkShoppingcart.click();
	}
	public void clickCheckout() {
		lnkCheckout.click();
	}
	public void mouseHoverMp3Player() {
		Actions ac = new Actions(super.driver);
		ac.moveToElement(wait.until(ExpectedConditions.visibilityOf(tabMP3Player))).perform();;
		ac.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(lnkTest21))).click().build().perform();;
	}
	
	public void typeSearchField(String productName) {
		fieldSearch.sendKeys(productName);;
	}
	public boolean isExistSearchField() {
		return fieldSearch.isDisplayed();
	}
	
	public void clickSearchbtn() {
		btnSearch.click();
	}
	public boolean isExistSearchbtn() {
		return btnSearch.isDisplayed();
	}
	public String getPhoneNo() {
		return txtPhoneno.getText();
	}
	public void clickCameras()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Cameras']"))).click();
	}
	public void clickWishlist() {
		lnkWishlist.click();
	}
	public void clickBtnCheckout() {
		btnCheckout.click();
	}
	public void clickbtncarouselMainPrev() {
		btncarouselMainPrev.click();	
	}
	public void clickbtncarouselMainNxt() {
		btncarouselMainNxt.click();
	}
	
	public void clickBulletCarouselMain() {
		for (WebElement blt : bulletCarouselMain)
			blt.click();
	}
	
	public void clickCarouselNxt() {
		btnCrslNext.click();;
	}
	public void clickCarouselPrev() {
		btnCrslPrev.click();
	}
	public void clickCarouselBullets() {
		for(WebElement bullet:bulletsCarousel)
		{
			bullet.click();
		}
	}
	public void getCarouselText() {
		for(WebElement element : elementCarousel)
		{
			System.out.println(element.getAttribute("alt"));

		}
	}
	public void scrollToCarousel() {
		
        new Actions(super.driver).moveToElement(Carousel).perform();
		wait.until(ExpectedConditions.visibilityOf(Carousel));

	}
	public void clickHome() {
		btnHome.click();
	}
	
	public boolean[] checkTabs() {
		boolean[] displaybool = new boolean[7];
		displaybool[0] = tabDesktop.isDisplayed();
		displaybool[1] = tabComponents.isDisplayed();
		displaybool[2] = tabTablets.isDisplayed();
		displaybool[3] = tabSoftwares.isDisplayed();
		displaybool[4] = tabPhonesPDAs.isDisplayed();
		displaybool[5] = tabCameras.isDisplayed();
		displaybool[6] = tabMP3Player.isDisplayed();
		return displaybool;
}
	public boolean checkFooter(){
		boolean displayFooter = true;
		for (WebElement lnk : lnkFooter)
			if(lnk.isDisplayed()==false)
			{
				 displayFooter=false;
				 break;
			}
		return displayFooter;
	}
	
	public boolean checkFooterHeading() {
		boolean displayFooter = true;
		for(WebElement lnk : lnkFooterHeading)
		
			if(lnk.isDisplayed()==false)
			{
				displayFooter=false;
				break;
			}
		return displayFooter;	
	}
	public String checkFooterYearandCompany() {
		return textFooterYearCompany.getText();
	}
	
	public void backwardpage() {
		driver.navigate().back();
	}
	public void clickOrderHistory() {
		lnkOrderHistory.click();
	}
	public void clickMyaccountDrp() {
		lnkMyAccountDrp.click();
	}
}