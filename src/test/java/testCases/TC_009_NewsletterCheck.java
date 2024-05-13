package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.NewsletterPage;
import testBase.BaseClass;

public class TC_009_NewsletterCheck extends BaseClass{
	@Test
	public void verify_Newsletter() {
		
		try {
			logger.info("*** TC_009_NewsletterCheck Started ***");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			logger.info("Login into the account");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(pr.getProperty("email"));
			lp.setPassword(pr.getProperty("password"));
			lp.clickLogin();
			
			logger.info("Going to click newsletter");
			MyAccountPage mp = new MyAccountPage(driver);
			mp.clickNewsletter();
			logger.info("Newsletter clicked");

			SoftAssert sa = new SoftAssert();
			NewsletterPage nw = new NewsletterPage(driver);
			sa.assertEquals(nw.getTextNewsletter(),"Newsletter Subscription");
			nw.clickBack();
			mp.clickNewsletter();
			logger.info("Newsletter clicked again");
			nw.clickRdoYes();
			nw.clickContinue();
			sa.assertEquals(nw.getMsgSuccessNewsletter(),"Success: Your newsletter subscription has been successfully updated!");
			mp.clickNewsletter();
			logger.info("Newsletter clicked third time");
			nw.clickRdoNo();
			logger.info("No radio button is selected");
			nw.clickContinue();
			sa.assertAll();
			logger.info("*** TC_009_NewsletterCheck Completed ***");

	}
		catch(AssertionError e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}

}
}