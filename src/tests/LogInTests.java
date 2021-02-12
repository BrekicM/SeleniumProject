package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tests.TestBase;

public class LogInTests extends TestBase{
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test
	public void validCredentialsLogin() {
		String email = excelReader.getCellData("TC1-Login", 5, 3);
		String password = excelReader.getCellData("TC1-Login", 6, 3);
		logIn(email, password);
		Assert.assertEquals(true, myAccountPage.getMyAccountPageLabel().isDisplayed());
	}
	
	@Test
	public void invalidEmailLogin() {
		String email = excelReader.getCellData("TC1-Login", 13, 3);
		String password = excelReader.getCellData("TC1-Login", 14, 3);
		logIn(email, password);
		Assert.assertEquals(true, authPage.getInvalidEmailAddressLabel().isDisplayed());
	}
	
	@Test
	public void invalidPasswordLogin() {
		String email = excelReader.getCellData("TC1-Login", 21, 3);
		String password = excelReader.getCellData("TC1-Login", 22, 3);
		logIn(email, password);
		Assert.assertEquals(true, authPage.getInvalidEmailAddressLabel().isDisplayed());
	}
	
	@Test
	public void noCredentialsLogin() {
		String email = "";
		String password = "";
		logIn(email, password);
		Assert.assertEquals(true, authPage.getInvalidEmailAddressLabel().isDisplayed());
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
}
