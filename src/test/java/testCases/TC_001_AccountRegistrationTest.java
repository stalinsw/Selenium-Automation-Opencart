package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration()
	{
		logger.info("**** starting TC_001_AccountRegistrationTest  *****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on registration link");
		
		
		logger.info("Entering customer details.. ");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomNumeric());
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("clicked on continue..");
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message..");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Account creation failed");		
		
		}
		catch(Exception e)
		{
			logger.error("test failed..");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		logger.info("**** finished TC_001_AccountRegistrationTest  *****");
		
	}
	
}