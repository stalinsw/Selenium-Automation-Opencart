package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationPage extends BaseClass{
	
	@Test(groups= {"sanity", "master"})
	public void verify_account_registration() {
		
		logger.info("**** Starting TC_001_AccountRegistrationPage *****");

		logger.debug("Application logs started.......");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");

		hp.clickRegister();
		logger.info("Clicked on Registration link");

		logger.info("Entering customer details.. ");
		AccountRegistrationPage rgpage=new AccountRegistrationPage(driver);
		rgpage.setFirstname(randomString().toUpperCase());
		rgpage.setLastname(randomString().toUpperCase());
		rgpage.setEmail(randomString()+"@gmail.com");
		rgpage.setTelephone(randomNumeric());
		
		String password=randomAlphaNumeric();
		rgpage.setPassword(password);
		rgpage.setConfirmPassword(password);
		
		rgpage.setPrivacyPolicy();
		rgpage.clickContinue();
		
		String confmsg=rgpage.getConfirmationMsg();
		logger.info("Validating expected message..");

		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Account creation failed");
	}
	catch(Exception e)
		{
		
		logger.error("Test failed");
		logger.debug("Debug logs.....");
		Assert.fail();
		}
		logger.debug("Application logs end....");
		logger.info("**** finished TC_001_AccountRegistrationTest *****");
		
	}
}
		