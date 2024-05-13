package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CameraProductPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductListPage;
import pageObjects.WishlistPage;
import testBase.BaseClass;

public class TC_008_WishListCheck extends BaseClass {
	@Test
	public void verify_wishlist() throws InterruptedException {

		try {
			logger.info("*** TC_008_WishListCheck Started ***");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			logger.info("Login into the account");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(pr.getProperty("email"));
			lp.setPassword(pr.getProperty("password"));
			lp.clickLogin();

			hp.clickCameras();
			logger.info("Camera tab clicked from my account");
			ProductListPage pl = new ProductListPage(driver);
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(pl.getTextCamera(), "Canon EOS 5D", "Test Failed");
			pl.clickItemCamera();

			CameraProductPage cp = new CameraProductPage(driver);
			cp.clickWishlist();
			logger.info("Checking soft assertions for verifications");
			sa.assertEquals(cp.getProductText(), "Canon EOS 5D");
			System.out.println(cp.getProductText());
			logger.info("Checking soft assertion 1 for verification");
			sa.assertEquals(cp.getWishlistText().replace("×", "").trim(),
					"Success: You have added Canon EOS 5D to your wish list!", "Test Failed");
			System.out.println(cp.getWishlistText().replace("×", "").trim()); // used to remove trailing spaces and x
																				// which is an hidden element in script

			hp.clickWishlist();
			WishlistPage wl = new WishlistPage(driver);
			wl.clickAddtoCart();

			sa.assertEquals(cp.isExistAddtoCart(), true);
			hp.clickWishlist();
			logger.info("Clicked wishlist");
			wl.clickDelete();
			logger.info("Clicked delete");
			sa.assertEquals(wl.getTextModify().replace("×", "").trim(), "Success: You have modified your wish list!");
			System.out.println(wl.getTextModify().replace("×", "").trim());
			logger.info("3rd soft assertion");
			sa.assertEquals(wl.getTextEmpty(), "Your wish list is empty.");
			logger.info("Completed soft asertions");
			wl.clickContinue();
			logger.info("Continue clicked");
			sa.assertAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
