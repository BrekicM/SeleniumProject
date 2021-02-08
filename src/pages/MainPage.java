package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement signInButton;
	
	public MainPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	public void clickOnSignInButton() {
		getSignInButton().click();
	}
}
