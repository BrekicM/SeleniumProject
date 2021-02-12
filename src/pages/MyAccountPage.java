package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAccountPageLabel;
	WebElement myAddressesButton;
	WebElement myPersonalInfoButton;
	WebElement myWishlistsButton;
	WebElement homeButton;
	
	public MyAccountPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getMyAccountPageLabel() {
		return driver.findElement(By.className("page-heading"));
	}

	public WebElement getMyAddressesButton() {
		return driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]/a/span"));
	}
	
	public WebElement getMyPersonalInfoButton() {
		return driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span"));
	}

	public WebElement getMyWishlistsButton() {
		return driver.findElement(By.xpath("//*[@id='center_column']/div/div[2]/ul/li"));
	}
	
	public WebElement getHomeButton() {
		return driver.findElement(By.xpath("//a[contains(@title, 'Home')]"));
	}

	public void clickOnMyAddressesButton() {
		getMyAddressesButton().click();
	}
	
	public void clickOnMyPersonalInfoButton() {
		getMyPersonalInfoButton().click();
	}
	
	public void clickOnMyWishlistsButton() {
		getMyWishlistsButton().click();
	}
	
	public void clickOnHomeButton() {
		getHomeButton().click();
	}
	
}
