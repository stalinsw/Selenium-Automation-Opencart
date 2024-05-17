package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CameraProductPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductListPage;
import testBase.BaseClass;

public class TC_013_AddReviewTest extends BaseClass{
	
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
		public void check_add_review() {
			
			try {
				HomePage hp = new HomePage(driver);
				hp.typeSearchField("Canon");
				hp.clickSearchbtn();
				
				ProductListPage pl = new ProductListPage(driver);
				pl.clickItemCamera();
				
				CameraProductPage cp =new CameraProductPage(driver);
				cp.clickWriteReview();
				cp.typeReviewName(randomString());
				cp.typeReview(randomLengthyString());
				cp.clickBltReview();
				cp.clickReviewContinue();
				Assert.assertEquals(cp.getMsgSuccessReview(), "Thank you for your review. It has been submitted to the webmaster for approval.");	
			}
			catch(AssertionError e) {
				System.out.print(e.getMessage());
				Assert.fail();
			}
		}
}
