package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LP3065Page extends BasePage {
	// constructor

	public LP3065Page(WebDriver driver){
		super(driver);
	}

	// locators
	@FindBy(xpath = "//input[@id='input-option-225']")
	WebElement deliveryDate;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btn_AddToCart;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_AddToCart;
	
	@FindBy(xpath = "//div//button//i[@class='fa-solid fa-heart']")
	WebElement link_AddToWishlist;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_AddToWishlist;
	
	@FindBy(xpath = "//span[normalize-space()='Checkout']")
	WebElement link_Checkout;
	
	// actions
	public void inputDeliveryDate() {
		LocalDate currentDate = LocalDate.now();
		
		//add 5 days to the current date to get delivery date
		LocalDate deliveryDate = currentDate.plusDays(5);
		
		//format the date into mm/dd/yyyy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDeliveryDate = deliveryDate.format(formatter);
                
        //put the date into the delivery date box
        driver.findElement(By.xpath("//input[@id='input-option-225']")).sendKeys(formattedDeliveryDate);
	}
	
	public void clickAddToCart() {
		btn_AddToCart.click();
	}
	
	public String getAddToCartMsg() {
		return msg_AddToCart.getText();
	}
	
	public void clickAddToWishlist() {
		link_AddToWishlist.click();
	}
	
	public String getAddToWishlistMsg() {
		return msg_AddToCart.getText();
	}
	
	public void clickCheckout() {
		link_Checkout.click();
	}
}
