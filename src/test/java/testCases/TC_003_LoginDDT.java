package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginddt(String email,String password, String exp)
	{
		/*Data is valid  - login success - test pass  - logout
		Data is valid -- login failed - test fail

		Data is invalid - login success - test fail  - logout
		Data is invalid -- login failed - test pass
		*/

		logger.info("**** Starting TC_003_LoginDDT  ****");

		try
		{
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link on the home page..");
		hp.clickLogin(); //Login link under MyAccount
		logger.info("clicked on login link under myaccount..");
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin(); //Login button
		logger.info("clicked on login button..");
		
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		if (exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
				Assert.assertTrue(true);
		}
	}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		logger.info("**** Finished TC_003_LoginDDT  ****");
	}

}
