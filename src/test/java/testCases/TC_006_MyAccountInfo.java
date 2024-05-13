package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInfoChange;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_006_MyAccountInfo extends BaseClass {
	@Test
	public void verify_myaccountinfo() {

		try {
			logger.debug("application logs started......");
			logger.info("**** starting TC_006_MyAccountInfo  *****");

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");

			hp.clickRegister();
			logger.info("Clicked on registration link");

			logger.info("Entering customer details.. ");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			String email = randomString() + "@gmail.com";// randomly generated the email
			regpage.setEmail(email);
			regpage.setTelephone(randomNumeric());

			String password = randomAlphaNumeric();

			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("clicked on continue..");

			String confmsg = regpage.getConfirmationMsg();

			logger.info("Validating expected message..");

			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Account creation failed");

			MyAccountPage mc = new MyAccountPage(driver);
			mc.clickLogout();

			Thread.sleep(3000);
			hp.clickMyAccount();
			logger.info("My account clicked");
			hp.clickLogin();
			logger.info("Login clicked");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			logger.info("Login button clicked");
			
			mc.clickMyAccount();

			logger.info("Going to change info in my account page");
			MyAccountInfoChange myinfo = new MyAccountInfoChange(driver);
			String newmail=randomString()+"@gmail.com";
			String pw=randomAlphaNumeric();
			myinfo.typeFname("Testing");
			myinfo.typeLname("Testing");
			myinfo.typeEmail(newmail);
			myinfo.typeTp("123456789");
			myinfo.clickContinue();
			System.out.print(myinfo.getTextAccntChange());
			Assert.assertEquals(myinfo.getTextAccntChange(), "Success: Your account has been successfully updated.");
					    
			logger.info("Navigating to password change page");
			mc.clickPassword();
			myinfo.typePassword(pw);
			myinfo.typeNewPasswrod(pw);
			myinfo.clickContPw();
			myinfo.getTextPswdChange();
			Assert.assertEquals(myinfo.getTextPswdChange(), "Success: Your password has been successfully updated.");
			
			//Login with new changed credentials
			mc.clickLogout();
			logger.info("Enterring new user credentials");
			hp.clickMyAccount();
			logger.info("My account clicked");
			hp.clickLogin();
			logger.info("Login clicked");

			lp.setEmail(newmail);
			lp.setPassword(pw);
			lp.clickLogin();
			logger.info("Login button clicked");
			Assert.assertEquals(mc.getPageTitle(), "My Account");
			
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
