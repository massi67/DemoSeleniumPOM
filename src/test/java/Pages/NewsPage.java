package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class NewsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//h1")
	WebElement header;

	@FindBy(xpath = "//span[@aria-label='Next']/parent::button")
	WebElement nextArrow;
	
	@FindBy(xpath = "(//li[text()='2012'])[2]")
	WebElement year_2012;
	
	@FindBy(xpath = "//div[@id='tabId8']//ul/li")
	List<WebElement> newsCount;
	
	@FindBy(xpath = "//footer//div[@class='social-contact']//li/a/i")
	List<WebElement> footerIcons;
	
	public NewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(header));
		return header.getText().trim();
	}
	
	public void findAndClick2012() {
		while(!year_2012.isDisplayed()) {
			nextArrow.click();
		}
		year_2012.click();
	}
	
	public int verifyTotalNews() {
		return newsCount.size();
	}
	
	public void verifyFooterIcons() {
		for(WebElement ele : footerIcons) {
			Assert.assertTrue(ele.isDisplayed());
		}
	}
}