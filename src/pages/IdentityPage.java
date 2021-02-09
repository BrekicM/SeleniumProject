package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdentityPage {
	WebDriver driver;
	WebElement mrButton;
	WebElement mrsButton;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement emailField;
	WebElement saveButton;
	WebElement currentPasswordField;
	WebElement personalInfoUpdateSuccessfulLabel;
	WebElement backToYourAccountButton;
	WebElement getAccountLabel;
	
	public IdentityPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}
	
	public WebElement getCurrentPasswordField() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getPersonalInfoUpdateSuccessfulLabel() {
		return driver.findElement(By.xpath("//p[@class='alert alert-success']"));
	}
	
	public WebElement getBackToYourAccountButton() {
		return driver.findElement(By.xpath("//ul[contains(@class, 'footer_links')]/li[1]/a"));
	}
	
	public WebElement getGetAccountLabel() {
		return driver.findElement(By.xpath("//a[@class='account']"));
	}
	
	public WebElement getMrButton() {
		return driver.findElement(By.id(""));
	}

	public WebElement getMrsButton() {
		return mrsButton;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public void clickFirstNameField() {
		getFirstNameField().click();
		getFirstNameField().clear();
	}
	
	public void clickLastNameField() {
		getLastNameField().click();
		getLastNameField().clear();
	}
	
	public void clickSaveButton() {
		getSaveButton().click();
	}
	
	public void clickCurrentPasswordField() {
		getCurrentPasswordField().click();
		getCurrentPasswordField().clear();
	}
	
	public void clickBackToYourAccountButton() {
		getBackToYourAccountButton().click();
	}
	
}
