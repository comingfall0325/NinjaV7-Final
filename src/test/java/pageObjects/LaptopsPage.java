package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopsPage extends BasePage {
	// constructor

	public LaptopsPage(WebDriver driver){
		super(driver);
	}
	
	//locators
	@FindBy(xpath = "//a[normalize-space()='HP LP3065']")
	WebElement link_HP3065;
	
	//actions
	public void clickHP3065() throws InterruptedException {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", link_HP3065);
		
		//Add a small wait
		Thread.sleep(1500);
		
		//Now click
		link_HP3065.click();
	}
}
