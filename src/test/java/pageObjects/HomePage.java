package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
//constructor
	public HomePage(WebDriver driver){
		super(driver);
	}
		
//Locators
	//Link - My Account
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement link_MyAccount;
	
	//link -login
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement link_Login;
	
	//link - Laptops & Notebooks
	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
	WebElement link_Laptops;
	
	//link - Show all laptops
	@FindBy(xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")
	WebElement link_ShowAllLaptops;
	
	//link - Affiliate
	@FindBy(xpath = "//a[normalize-space()='Affiliate']")
	WebElement link_affiliate;
	
//Action Methods
	public void clickMyAccount(){
		link_MyAccount.click();
	}
	
	public void clickLogin() {
		link_Login.click();
	}
	
	public void clickLaptops() {
		link_Laptops.click();
	}
	
	public void clickShowAllLaptops() {
		link_ShowAllLaptops.click();
	}
	
	public void clickAffiliate() throws InterruptedException {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", link_affiliate);
		
		//Add a small wait
		Thread.sleep(500);
		
		//Now click
		link_affiliate.click();
	}
}
