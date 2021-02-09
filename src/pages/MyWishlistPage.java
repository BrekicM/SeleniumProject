package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistPage {
	WebDriver driver;
	WebElement wishlistNameField;
	WebElement saveButton;
	WebElement removeButton;
	WebElement firstWishlistLabel;
	WebElement wishlistRow;

	public MyWishlistPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getWishlistNameField() {
		return driver.findElement(By.id("name"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public WebElement getRemoveButton() {
		return driver.findElement(By.className("icon-remove"));
	}
	
	public WebElement getFirstWishlistLabel() {
		return driver.findElement(By.xpath("//div[@id='block-history']/table/tbody/tr/td/a"));
	}

	public WebElement getWishlistRow() {
		return driver.findElement(By.xpath("//div[@id='block-history']/table/tbody/tr"));
	}

	public void clickWishlistNameField() {
		getWishlistNameField().clear();
		getWishlistNameField().click();
	}
	
	public void clickSaveButton() {
		getSaveButton().click();
	}
	
	public void clickRemoveButton() {
		getRemoveButton().click();
	}
}
