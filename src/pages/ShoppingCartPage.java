package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	WebDriver driver;
	WebElement plusButton;
	WebElement proceedToCheckoutButton;
	WebElement productQuantityField;
	WebElement deleteFromCartIcon;
	WebElement oneItemInCartLabel;
	WebElement numberOfProductsInCart;
	WebElement cartEmptyLabel;
	
	public ShoppingCartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getPlusButton() {
		return driver.findElement(By.className("icon-plus"));
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.xpath("//p[contains(@class,'cart_navigation')]/a[1]"));
	}
	
	public WebElement getProductQuantityField() {
		return driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr/td[5]/input[1]"));
	}

	public WebElement getDeleteFromCartIcon() {
		return driver.findElement(By.className("icon-trash"));
	}
	
	public WebElement getOneItemInCartLabel() {
		return driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
	}

	public WebElement getNumberOfProductsInCart() {
		return driver.findElement(By.id("summary_products_quantity"));
	}

	public WebElement getCartEmptyLabel() {
		return driver.findElement(By.xpath("//p[contains(@class, 'alert')]"));
	}

	public void clickPlusButton() {
		getPlusButton().click();
	}
	
	public void clickProceedToCheckoutButton() {
		getProceedToCheckoutButton().click();
	}
	
	public void clickDeleteFromCartIcon() {
		getDeleteFromCartIcon().click();
	}
	
}
