package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage {
	WebDriver driver;
	WebElement emailLoginField;
	WebElement passwordField;
	WebElement signInButton;
	WebElement invalidEmailAddressLabel;
	
	public AuthPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getEmailLoginField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}
	
	
	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	
	public WebElement getInvalidEmailAddressLabel() {
		return driver.findElement(By.cssSelector("div.alert.alert-danger"));
	}

	public void inputLoginEmail(String email) {
		getEmailLoginField().clear();
		getEmailLoginField().sendKeys(email);
	}
	
	public void inputPassword(String password) {
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}
	
	public void clickSignInButton() {
		getSignInButton().click();
	}
	
}
