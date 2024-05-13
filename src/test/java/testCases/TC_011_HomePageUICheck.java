package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_011_HomePageUICheck extends BaseClass{
	

	 @BeforeClass
	 public void login() { 
		 
		 HomePage hp = new HomePage(driver);
		 hp.clickMyAccount(); 
		 hp.clickLogin();
	  
		 logger.info("Login into the account"); 
		 LoginPage lp = new LoginPage(driver);
		 lp.setEmail(pr.getProperty("email"));
		 lp.setPassword(pr.getProperty("password")); 
		 lp.clickLogin(); 
		 hp.clickHome();
	 }
	
	@Test(priority=1)
	public void verify_tabs() {
		try {
		HomePage hp = new HomePage(driver);
		boolean[] AssertBool={true, true, true, true, true, true, true};
		Assert.assertEquals(hp.checkTabs(),AssertBool);
	}
		catch(AssertionError e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void verify_footer() {
		try {
			HomePage hp = new HomePage(driver);
			Assert.assertEquals(hp.checkFooter(), true);
			Assert.assertEquals(hp.checkFooterHeading(), true);
			Assert.assertEquals(hp.checkFooterYearandCompany(), "Powered By OpenCart" + "\n" + "Your Store © 2024");
		}
		catch(AssertionError e)
		{
			System.out.print(e.getMessage());
			Assert.fail();
		}
	}
	@Test(priority=3)
	public void verify_header_tabs() throws InterruptedException {
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickWishlist();
		hp.backwardpage();
		hp.clickShoppingCart();
		hp.backwardpage();
		hp.clickCheckout();
		hp.backwardpage();
		hp.clickBtnCheckout();
		Assert.assertEquals(hp.isExistSearchField(), true);
		Assert.assertEquals(hp.isExistSearchbtn(), true);
		Assert.assertEquals(hp.getPhoneNo(), "123456789");
		Assert.assertEquals(driver.getTitle(), "Your Store");
		}
		catch(AssertionError e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
