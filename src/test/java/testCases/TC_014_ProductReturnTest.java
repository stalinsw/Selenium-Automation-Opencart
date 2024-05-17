package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.CameraProductPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.OrderHistoryPage;
import pageObjects.ProductListPage;
import pageObjects.ProductReturnPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_014_ProductReturnTest extends BaseClass {
	@Test
	public void verify_product_return() {
		try {
			logger.info("****** started TC_014_ProductReturnTest *****");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");

			hp.clickRegister();
			logger.info("Clicked on registration link");

			logger.info("Entering customer details.. ");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			String fname = randomString().toUpperCase();
			regpage.setFirstName(fname);

			String lname = randomString().toUpperCase();
			regpage.setLastName(lname);
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

			HomePage hm = new HomePage(driver);
			hm.clickMyAccount();
			logger.info("My account clicked");
			hm.clickLogin();
			logger.info("Login clicked");

			LoginPage lp = new LoginPage(driver);
			logger.info("Enterring user credentials");
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			logger.info("Login button clicked");

			hm.clickCameras();
			ProductListPage pl = new ProductListPage(driver);
			pl.clickItemCamera();

			CameraProductPage cp = new CameraProductPage(driver);
			cp.clickDropdown();
			cp.typeQuantity(pr.getProperty("quantity"));
			cp.clickAddToCart();

			String rslt = cp.getProductText();
			Assert.assertEquals("Success: You have added " + rslt + " to your shopping cart!",
					"Success: You have added Canon EOS 5D to your shopping cart!");

			hm.clickShoppingCart();

			ShoppingCartPage sc = new ShoppingCartPage(driver);
			sc.clickCheckout();

			sc.typeFname(randomString());
			
			sc.typeLname(randomString());

			sc.typeCompany(randomString());

			sc.typeaddress1(randomString());

			sc.typeaddress2(randomString());

			sc.typeCity(randomString());

			sc.typePost(randomNumeric());

			sc.drpCountry();

			sc.drpRegion();

			sc.clickCheckout2();

			CheckoutPage cop = new CheckoutPage(driver);
			cop.clickContinue();
			cop.clickContinue2();
			cop.clickChkPrivacy();
			cop.clickContinue4();
			cop.clickConfirmOrder();
			cop.waitforAlertandAccept();
			cop.clickConfirmOrder();
			String tx = cop.getTextConfirmOrder();
			Assert.assertEquals(tx, "Your order has been placed!");
			cop.clickFinalContinue();
			Assert.assertTrue(true);
			hp.clickHome();
			hp.clickMyAccount();
			hp.clickMyaccountDrp();
		
			MyAccountPage ac = new MyAccountPage(driver);
			ac.clickOrderHistory();
			SoftAssert sa = new SoftAssert();
			OrderHistoryPage oh = new OrderHistoryPage(driver);
			sa.assertEquals(oh.getCustomerName(),fname+" "+lname );
			sa.assertEquals(oh.getPrice(), "$245.00");
			oh.clickView();
			sa.assertEquals(oh.getProductName().replace("- Select: Red", "").trim(), "Canon EOS 5D");
			oh.clickReturn();

			ProductReturnPage pr = new ProductReturnPage(driver);
			pr.rdoBtn();
			pr.typeTextArea(randomLengthyString());
			pr.clickSubmit();
			sa.assertEquals(pr.getTextSuccessReturn(), "Thank you for submitting your return request. "
					+ "Your request has been sent to the relevant department for processing.");
			sa.assertAll();
			
		} 
		
		catch (AssertionError e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}