package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddressBookPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_007_AddressBookAddDelete extends BaseClass{
	@Test
	public void verify_addressbook_edit_delete()
	{
		try {
			logger.debug("application logs started......");
			logger.info("**** starting TC_007_AddressBookAddDelete  *****");

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
			mc.clickAddressBook();
			
			AddressBookPage ad = new AddressBookPage(driver);
			SoftAssert sa = new SoftAssert();    //as we are having multiple asserts
			//First address
			logger.info("First new address(default address) adding");
			ad.clickNewAddress();
			ad.typeFname(randomString());
			ad.typeLname(randomString());
			ad.typeCom(randomString());
			ad.typeAddress1(randomString());
			ad.typeAddress2(randomString());
			ad.typeCity(randomString());
			ad.typePost(randomNumeric());
			ad.clickCountrydrp();
			ad.clickRegiondrp();
			ad.clickRdo();
			ad.clickContinue();
			sa.assertEquals(ad.getMsgAdd(), "Your address has been successfully added");
			
			//Second Address
			logger.info("Second new address adding");
			ad.clickNewAddress();
			ad.typeFname(randomString());
			ad.typeLname(randomString());
			ad.typeCom(randomString());
			ad.typeAddress1(randomString());
			ad.typeAddress2(randomString());
			ad.typeCity(randomString());
			ad.typePost(randomNumeric());
			ad.clickCountrydrp();
			ad.clickRegiondrp();
			ad.clickContinue();
			sa.assertEquals(ad.getMsgAdd(), "Your address has been successfully added");

			driver.navigate().refresh();
			logger.info("Deleting address except default address");
			ad.clickDel(); //delete address records except default
			driver.switchTo().alert().accept();
			sa.assertEquals(ad.getMsgDelete(), "Your address has been successfully deleted");
			sa.assertAll();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		}
}