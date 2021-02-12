package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
	WebDriver driver;
	WebElement addToCartButton;
	WebElement closePopupWindow;
	WebElement cartButton;
	
	public ItemPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//p[@id='add_to_cart']/button"));
	}
	
	public WebElement getClosePopupWindow() {
		return driver.findElement(By.className("cross"));
	}
	
	public WebElement getCartButton() {
		return driver.findElement(By.xpath("//div[@class='shopping_cart']/a"));
	}

	public void clickOnAddToCartButton() {
		getAddToCartButton().click();
	}
	
	public void clickOnClosePopupWindow() {
		getClosePopupWindow().click();
	}
	
	public void clickOnCartButton() {
		getCartButton().click();
	}
}
