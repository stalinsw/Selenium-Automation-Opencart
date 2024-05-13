package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_010_CarouselSliderCheck extends BaseClass {
	@Test
	public void verify_main_Carousel_Slider() {
		try {
		HomePage hp = new HomePage(driver);
		hp.clickbtncarouselMainPrev();
		hp.clickbtncarouselMainNxt();
		hp.clickBulletCarouselMain();
	} 
		catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
	}
	}

	@Test
	public void verify_isExist_Carousel_Slider() {

		try {
			logger.info("*** TC_010_CarouselSliderCheck Started ***");
			HomePage hp = new HomePage(driver);
			logger.info("Scrolled to view the carousel");
			hp.scrollToCarousel();
			Thread.sleep(5000);
			hp.clickCarouselNxt();
			hp.clickCarouselNxt();
			hp.clickCarouselPrev();
			hp.clickCarouselPrev();
			hp.clickCarouselBullets();
			hp.getCarouselText();
			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}

	}
}
