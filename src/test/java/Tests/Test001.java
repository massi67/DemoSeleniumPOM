package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.NewsPage;
import Pages.SportsPage;

public class Test001 extends BaseTest {

	//Test 1234
	@Test
	public void myFirstTestCase() {
		HomePage homePageObj = new HomePage(driver);
		String title = homePageObj.getTitle();
		Assert.assertEquals(title, "HCL Group", "Verifying home page title.");
		String description = homePageObj.mouseHoverHCLTechAndGetDescription();
		Assert.assertEquals(description, "HCLTech is a next-generation global technology company that helps enterprises reimagine their businesses for the digital age. Our technology products, services, and engineering prowess are built on the back of four decades of innovation, with a world-renowned management philosophy, a strong culture of invention and risk-taking, and a relentless focus on customer relationships.");
		int sliderCount = homePageObj.getSliderCount();
		Assert.assertEquals(sliderCount, 9, "Verifying sliders.");
		homePageObj.scrollToViewAndClickSportsLink();
		
		SportsPage sportsPageObj = new SportsPage(driver);
		String header = sportsPageObj.getPageHeader();
		Assert.assertEquals(header, "HCL Sports", "Verifying sports page header.");
		sportsPageObj.clickMenuIcon();
		sportsPageObj.mouseHoverMediaCenterAndClickNewsLink();
		
		NewsPage newsPageObj = new NewsPage(driver);
		String header1 = newsPageObj.getPageHeader();
		Assert.assertTrue(header1.contains("NEWS RELEASE"));
		newsPageObj.findAndClick2012();
		int totalNews = newsPageObj.verifyTotalNews();
		Assert.assertEquals(totalNews, 4, "Verifying total news.");
		newsPageObj.verifyFooterIcons();
		
	}
}
