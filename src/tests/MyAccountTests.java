package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class MyAccountTests extends TestBase{
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test(priority = 0)
	public void updateAddress() {
		String newAddress = excelReader.getCellData("TC2-MyAccountSection", 6, 3);
		String oldAddress = excelReader.getCellData("TC2-MyAccountSection", 9, 3);
		
		validLogIn();
		changeAddress(newAddress);
		Assert.assertEquals(myAdressesPage.getCurrentAddressLabel().getText(), newAddress);
		revertAddress(oldAddress);
		Assert.assertEquals(myAdressesPage.getCurrentAddressLabel().getText(), oldAddress);

	}
	
	@Test(priority = 5)
	public void addAddress() throws InterruptedException {		
		validLogIn();
		myAccountPage.clickOnMyAddressesButton();
		myAdressesPage.clickAddNewAddressButton();
		anotherAddressCreation();
		Assert.assertEquals(myAdressesPage.getSecondAddressLabel().getText(), excelReader.getCellData("TC2-MyAccountSection", 20, 3));
	}
	
	@Test(priority = 10)
	public void deleteAddress() {
		validLogIn();
		myAccountPage.clickOnMyAddressesButton();
		myAdressesPage.clickDeleteSecondAddressButton();
		driver.switchTo().alert().accept();
		Assert.assertEquals(myAdressesPage.getDeleteButtons().size(), 1);
		
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	public void anotherAddressCreation() {
		String address = excelReader.getCellData("TC2-MyAccountSection", 15, 3);
		String city = excelReader.getCellData("TC2-MyAccountSection", 16, 3);
		String zipCode = excelReader.getCellData("TC2-MyAccountSection", 18, 3);
		String mobilePhone = excelReader.getCellData("TC2-MyAccountSection", 19, 3);
		String addressTitle = excelReader.getCellData("TC2-MyAccountSection", 20, 3);
		
		myAdressesPage.clickAddressField();
		myAdressesPage.getAddressField().sendKeys(address);
		myAdressesPage.clickCityField();
		myAdressesPage.getCityField().sendKeys(city);
		myAdressesPage.selectStateFromDropDown(2);
		myAdressesPage.clickZipCodeField();
		myAdressesPage.getZipCodeField().sendKeys(zipCode);
		myAdressesPage.clickMobilePhoneNumberField();
		myAdressesPage.getMobilePhoneNumberField().sendKeys(mobilePhone);
		myAdressesPage.clickAddressAliasField();
		myAdressesPage.getAddressAliasField().sendKeys(addressTitle);
		myAdressesPage.clickSubmitAddressButton();
	}
	
	public void changeAddress(String address) {
		myAccountPage.clickOnMyAddressesButton();
		myAdressesPage.clickUpdateAddressButton();
		myAdressesPage.clickAddressField();
		myAdressesPage.getAddressField().sendKeys(address);
		myAdressesPage.clickSaveButton();	
	}
	
	public void revertAddress(String address) {
		myAdressesPage.clickUpdateAddressButton();
		myAdressesPage.clickAddressField();
		myAdressesPage.getAddressField().sendKeys(address);
		myAdressesPage.clickSaveButton();	
	}
	
}
