package testCases;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_012_MouseHoverTest extends BaseClass{
	
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
	 @Test
	 public void checkHomeMouseHover() {
		 try {
		 HomePage hp = new HomePage(driver);
		 hp.clickHome();
		 hp.mouseHoverMp3Player();
		 Assert.assertEquals(driver.getTitle(), "test 21");
		 }
		 catch(Exception e )
		 {
			 System.out.print(e.getMessage());
			 Assert.fail();
		 }
	 }

}
