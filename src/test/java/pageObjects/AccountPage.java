package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {
	// constructor

	public AccountPage(WebDriver driver){
		super(driver);
	}
	
	//locators
	@FindBy(xpath = "//h1[normalize-space()='My Account']")
	WebElement msg_loginSuccess;
	
	@FindBy(xpath = "//img[@title='Your Store']")
	WebElement link_homePage;
	
	@FindBy(xpath = "//body/div[@id='container']/main/div[@id='account-account']/div[1]")
	WebElement msg_addAffiliate;
	
	@FindBy(xpath = "//li[@class='list-inline-item']//i[@class='fa-solid fa-caret-down']")
	WebElement dropDown_MyAccount;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement link_Logout;
	
	//action methods
	public WebElement getLoginMsg() {
		return msg_loginSuccess;
	}
	
	public void clickHomePage() {
		link_homePage.click();
	}
	
	public boolean msgAddAffiliate() {
		return msg_addAffiliate.getText().contains("Success");
	}
	
	public void clickMyAccountDropDown() {
		dropDown_MyAccount.click();
	}
	
	public void clickLogout() {
		link_Logout.click();
	}
}
