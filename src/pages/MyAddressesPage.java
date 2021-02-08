package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAddressesPage {
	WebDriver driver;
	WebElement updateAddressButton;
	WebElement addressField;
	WebElement cityField;
	WebElement zipCodeField;
	WebElement mobilePhoneNumberField;
	WebElement saveButton;
	WebElement currentAddressLabel;
	WebElement addNewAddressButton;
	WebElement stateDropdownSelection;
	
	public MyAddressesPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}
	public WebElement getUpdateAddressButton() {
		return driver.findElement(By.linkText("Update"));
	}
	
	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	
	public WebElement getCurrentAddressLabel() {
		return driver.findElement(By.className("address_address1"));
	}
	
	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.xpath("//a[@title='Add an address']"));
	}
	
	public WebElement getStateDropdownSelection() {
		return driver.findElement(By.id("id_state"));
	}
	
	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}
	
	public WebElement getZipCodeField() {
		return driver.findElement(By.id("postcode"));
	}
	
	
	
	public WebElement getMobilePhoneNumberField() {
		return mobilePhoneNumberField;
	}
	public void clickUpdateAddressButton() {
		getUpdateAddressButton().click();
	}
	
	public void clickAddressField() {
		getAddressField().click();
		getAddressField().clear();
	}
	
	public void clickSaveButton() {
		getSaveButton().click();
	}
	
	public void clickAddNewAddressButton() {
		getAddNewAddressButton().click();
	}
	
	public void clickCityField() {
		getAddressField().click();
		getAddressField().clear();
	}
	
	public void clickZipCodeField() {
		getZipCodeField().click();
		getZipCodeField().clear();
	}
	
	public void selectStateFromDropDown(String state) {
		Select stateFromDropDown = new Select(getStateDropdownSelection());
		stateFromDropDown.selectByValue(state);
	}
	
}
