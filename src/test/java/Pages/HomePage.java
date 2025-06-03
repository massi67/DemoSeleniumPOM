package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	//creating webdriver object
	WebDriver driver;

	@FindBy(xpath = "//p[text()='HCLTech']/parent::li")
	WebElement hclTechLink;
	
	@FindBy(xpath = "(//p[text()='HCLTech']/parent::li/div/p)[1]")
	WebElement hclTechDescription;
	
	@FindBy(xpath = "//ol[@class='carousel-indicators']/li")
	List<WebElement> sliders;
	
	@FindBy(xpath = "//div[@class='content-box']//a[normalize-space(text())='HCL Sports']")
	WebElement sportsLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String mouseHoverHCLTechAndGetDescription() {
		Actions act = new Actions(driver);
		act.moveToElement(hclTechLink).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(hclTechDescription));
		String description = hclTechDescription.getText();
		return description;
	}
	
	public int getSliderCount() {
		return sliders.size();
	}
	
	public void scrollToViewAndClickSportsLink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", sportsLink);
		sportsLink.click();
	}
}
