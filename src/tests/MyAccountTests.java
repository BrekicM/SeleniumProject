package tests;

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
	
	//@Test
	public void updateAddress() {
		String email = excelReader.getCellData("TC1-Login", 5, 3);
		String password = excelReader.getCellData("TC1-Login", 6, 3);
		String newAddress = excelReader.getCellData("TC2-MyAccountSection", 6, 3);
		String oldAddress = excelReader.getCellData("TC2-MyAccountSection", 9, 3);
		logIn(email, password);
		
		myAccountPage.clickOnMyAddressesButton();
		myAdressesPage.clickUpdateAddressButton();
		myAdressesPage.clickAddressField();
		myAdressesPage.getAddressField().sendKeys(newAddress);
		myAdressesPage.clickSaveButton();
		Assert.assertEquals(myAdressesPage.getCurrentAddressLabel().getText(), newAddress);
		myAdressesPage.clickUpdateAddressButton();
		myAdressesPage.clickAddressField();
		myAdressesPage.getAddressField().sendKeys(oldAddress);
		myAdressesPage.clickSaveButton();
		Assert.assertEquals(myAdressesPage.getCurrentAddressLabel().getText(), oldAddress);
	}
	
	@Test
	public void addAddress() {
		String email = excelReader.getCellData("TC1-Login", 5, 3);
		String password = excelReader.getCellData("TC1-Login", 6, 3);
		String address = excelReader.getCellData("TC2-MyAccountSection", 15, 3);
		
		logIn(email, password);
		
		myAccountPage.clickOnMyAddressesButton();
		myAdressesPage.clickAddNewAddressButton();
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
		myAdressesPage.selectStateFromDropDown("Alaska");
		myAdressesPage.clickZipCodeField();
		myAdressesPage.getZipCodeField().sendKeys(zipCode);
	}
	
	//dodati metodu za test od gore, update adrese
}
