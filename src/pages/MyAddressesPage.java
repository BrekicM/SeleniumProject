package pages;

import java.util.List;

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
	WebElement addressAliasField;
	WebElement saveButton;
	WebElement currentAddressLabel;
	WebElement addNewAddressButton;
	WebElement stateDropdownSelection;
	WebElement submitButton;
	WebElement secondAddressLabel;
	WebElement deleteSecondAddressButton;
	List<WebElement> deleteButtons;
	
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
		return driver.findElement(By.id("phone_mobile"));
	}
	
	public WebElement getAddressAliasField() {
		return driver.findElement(By.id("alias"));
	}
	
	public WebElement getSubmitButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	
	public WebElement getSecondAddressLabel() {
		return driver.findElement(By.xpath("//div[@class='addresses']/div/div[2]/ul/li/h3"));
	}
	
	public WebElement getDeleteSecondAddressButton() {
		return driver.findElement(By.xpath("//div[@class='addresses']/div/div[2]/ul/li[9]/a[2]"));
	}
	
	public List<WebElement> getDeleteButtons() {
		return driver.findElements(By.xpath("//a[contains(@title, 'Delete')]"));
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
		getCityField().click();
		getCityField().clear();
	}
	
	public void clickZipCodeField() {
		getZipCodeField().click();
		getZipCodeField().clear();
	}
	
	public void clickMobilePhoneNumberField() {
		getMobilePhoneNumberField().click();
		getMobilePhoneNumberField().clear();
	}
	
	public void clickAddressAliasField() {
		getAddressAliasField().click();
		getAddressAliasField().clear();
	}
	
	public void clickSubmitAddressButton() {
		getSubmitButton().click();
	}
	
	public void clickDeleteSecondAddressButton() {
		getDeleteSecondAddressButton().click();
	}
	
	public void selectStateFromDropDown(int index) {
		Select stateFromDropDown = new Select(getStateDropdownSelection());
		stateFromDropDown.selectByIndex(index);
	}
	
}
