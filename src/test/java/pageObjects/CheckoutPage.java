package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
//constructor
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
//locators
	@FindBy(xpath = "//strong[normalize-space()='login page']")
	WebElement link_Login;
	
	@FindBy(xpath = "//select[@id='input-shipping-address']")
	WebElement dropdown_ShippingAddress;
	
	@FindBy(xpath = "//button[@id='button-shipping-methods']")
	WebElement shippingMethod;
	
	@FindBy(xpath = "//button[@id='button-shipping-method']")
	WebElement flatRateShipping;
	
	@FindBy(xpath = "//button[@id='button-payment-methods']")
	WebElement paymentMethod;
	
	@FindBy(xpath = "//button[@id='button-payment-method']")
	WebElement cash;
	
	@FindBy(xpath = "//button[@id='button-confirm']")
	WebElement btn_ConfirmOrder;
	
//action methods
	public void clickLogin() {
		link_Login.click();
	}
	
	public void selectAddress() {
		Select select = new Select(dropdown_ShippingAddress);
		select.selectByIndex(1);
	}
	
	public void selectShippingMethod() {
		shippingMethod.click();
		flatRateShipping.click();
	}
	
	
	public void selectPaymentMethod() {
		paymentMethod.click();
		cash.click();
	}
	
	public void comfirmOrder() throws InterruptedException {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btn_ConfirmOrder);
		
		//Add a small wait
		Thread.sleep(500);
		
		//Now click
		btn_ConfirmOrder.click();
	}
	
	
}

