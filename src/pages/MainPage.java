package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement signInButton;
	WebElement secondProductImage;
	WebElement oneItemInCartLabel;
	WebElement shoppingCartButton;
	WebElement proceedToCheckoutButton;
	WebElement addToCartButton;

	public MainPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	public WebElement getSecondProductImage() {
		return driver.findElement(By.xpath("//ul[@id='homefeatured']/li[2]/div/div/div"));
	}

	public WebElement getOneItemInCartLabel() {
		return driver.findElement(By.xpath("//div[@class='clearfix']/div[2]/span[2]"));
	}

	public WebElement getShoppingCartButton() {
		return driver.findElement(By.className("shopping_cart"));
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.xpath("//div[@class='button-container']/a"));
	}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//ul[@id='homefeatured']/li[2]/div/div/div[2]/a"));
	}

	public void clickOnSignInButton() {
		getSignInButton().click();
	}
	
	public void clickOnSecondProductImage() {
		getSecondProductImage().click();
	}
	
	public void clickShoppingCartButton() {
		getShoppingCartButton().click();
	}
	
	public void clickOnProceedToCheckoutButton() {
		getProceedToCheckoutButton().click();
	}
	
	public void clickOnAddToCartButton() {
		getAddToCartButton().click();
	}
	
}
