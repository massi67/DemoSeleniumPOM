package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SportsPage {
	//change by Basavaraj
	WebDriver driver;
	
	@FindBy(xpath = "//h2")
	WebElement header;

	@FindBy(xpath = "//div[@class='burger']/div")
	WebElement menu;
	
	@FindBy(xpath = "//a[text()='Media Center ']")
	WebElement mediaCenter;
	
	@FindBy(xpath = "//a[text()=' News']")
	WebElement news;
	
	public SportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(header));
		return header.getText().trim();
	}
	
	public void clickMenuIcon() {
		menu.click();
	}
	
	public void mouseHoverMediaCenterAndClickNewsLink() {
		Actions act = new Actions(driver);
		act.moveToElement(mediaCenter).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(news));
		news.click();
	}
	//test
	//adding this line to create merge conflict
}
