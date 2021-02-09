package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInfoTests extends TestBase{
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test
	public void editPersonalInfo() {		
		String changedFirstName = excelReader.getCellData("TC3-MyPersonalInfo", 6, 3);
		String currentPassword = excelReader.getCellData("TC3-MyPersonalInfo", 7, 3);
		String revertFirstName = excelReader.getCellData("TC3-MyPersonalInfo", 11, 3);
		
		validLogIn();
		changeFirstName(changedFirstName, currentPassword);
		Assert.assertEquals(true, identityPage.getPersonalInfoUpdateSuccessfulLabel().isDisplayed());
		Assert.assertEquals(identityPage.getGetAccountLabel().getText(), excelReader.getCellData("TC3-MyPersonalInfo", 8, 3));
		identityPage.clickBackToYourAccountButton();
		changeFirstName(revertFirstName, currentPassword);
		Assert.assertEquals(true, identityPage.getPersonalInfoUpdateSuccessfulLabel().isDisplayed());
		Assert.assertEquals(identityPage.getGetAccountLabel().getText(), excelReader.getCellData("TC3-MyPersonalInfo", 13, 3));
		
		/*myAccountPage.clickOnMyPersonalInfoButton();
		identityPage.clickFirstNameField();
		identityPage.getFirstNameField().sendKeys(changedFirstName);
		identityPage.clickCurrentPasswordField();
		identityPage.getCurrentPasswordField().sendKeys(currentPassword);
		identityPage.clickSaveButton();
		Assert.assertEquals(true, identityPage.getPersonalInfoUpdateSuccessfulLabel().isDisplayed());
		Assert.assertEquals(identityPage.getGetAccountLabel().getText(), "Zarko B");
		identityPage.clickBackToYourAccountButton();
		revertToOriginalFirstName();*/
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	/*public void changeFirstName(String email, String password, String changedFirstName, String currentPassword) {
		email = excelReader.getCellData("TC1-Login", 5, 3);
		password = excelReader.getCellData("TC1-Login", 6, 3);
		logIn(email, password);
		
		changedFirstName = excelReader.getCellData("TC3-MyPersonalInfo", 6, 3);
		currentPassword = excelReader.getCellData("TC3-MyPersonalInfo", 7, 3);
		
		myAccountPage.clickOnMyPersonalInfoButton();
		identityPage.clickFirstNameField();
		identityPage.getFirstNameField().sendKeys(changedFirstName);
		identityPage.clickCurrentPasswordField();
		identityPage.getCurrentPasswordField().sendKeys(currentPassword);
		identityPage.clickSaveButton();
		Assert.assertEquals(true, identityPage.getPersonalInfoUpdateSuccessfulLabel().isDisplayed());
		Assert.assertEquals(identityPage.getGetAccountLabel().getText(), "Zarko B");
	}*/
	
	/*public void revertToOriginalFirstName() {
		String revertFirstName = excelReader.getCellData("TC3-MyPersonalInfo", 11, 3);
		String currentPassword = excelReader.getCellData("TC3-MyPersonalInfo", 12, 3);
		
		myAccountPage.clickOnMyPersonalInfoButton();
		identityPage.clickFirstNameField();
		identityPage.getFirstNameField().sendKeys(revertFirstName);
		identityPage.clickCurrentPasswordField();
		identityPage.getCurrentPasswordField().sendKeys(currentPassword);
		identityPage.clickSaveButton();
		Assert.assertEquals(true, identityPage.getPersonalInfoUpdateSuccessfulLabel().isDisplayed());
		Assert.assertEquals(identityPage.getGetAccountLabel().getText(), "Marko B");
	}*/
	
	public void changeFirstName(String firstName, String currentPassword) {
		myAccountPage.clickOnMyPersonalInfoButton();
		identityPage.clickFirstNameField();
		identityPage.getFirstNameField().sendKeys(firstName);
		identityPage.clickCurrentPasswordField();
		identityPage.getCurrentPasswordField().sendKeys(currentPassword);
		identityPage.clickSaveButton();
	}
}
