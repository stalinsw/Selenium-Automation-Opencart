package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;
import testBase.BaseClass;

public class TC_004_SearchProduct extends BaseClass{
	@Test
	public void verify_search_product(){

				logger.info("**** Starting TC_004_SearchProduct  ****");
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
				lp.setEmail(pr.getProperty("email"));
				lp.setPassword(pr.getProperty("password"));
				lp.clickLogin(); //Login button
				logger.info("clicked on login button..");
				
				hp.typeSearchField(pr.getProperty("searchProductName"));
				logger.info("searching the product");
				hp.clickSearchbtn();
				  
				ProductSearchPage ps = new ProductSearchPage(driver);
				boolean rslt = ps.isSearchPageExists();
				Assert.assertEquals(rslt, true, "Test failed");
				}
				catch(Exception e)
				{
					Assert.fail();
				}
				
				logger.info("**** Finished TC_004_SearchProduct  ****");
			}
		}

