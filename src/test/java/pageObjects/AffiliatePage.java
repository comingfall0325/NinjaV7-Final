package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliatePage extends BasePage{
//constructor
	public AffiliatePage(WebDriver driver) {
		super(driver);
	}
	
//locators
	@FindBy(xpath = "//input[@id='input-company']")
	WebElement box_Company;
	
	@FindBy(xpath = "//input[@id='input-website']")
	WebElement box_Website;
	
	@FindBy(xpath = "//input[@id='input-tax']")
	WebElement box_taxID;
	
	@FindBy(xpath = "//input[@id='input-cheque']")
	WebElement box_Cheque;
	
	@FindBy(xpath = "//form[@id='form-affiliate']//button[@type='submit']")
	WebElement btn_continue;
	
//action methods
	public void inputCompany(String company) {
		box_Company.sendKeys(company);
	}
	
	public void inputWebsite(String website) {
		box_Website.sendKeys(website);
	}
	
	public void inputTaxID(String taxID) {
		box_taxID.sendKeys(taxID);
	}
	
	public void inputCheque(String cheque) {
		box_Cheque.sendKeys(cheque);
	}
	
	public void clickContinue() {
		btn_continue.click();
	}
}
