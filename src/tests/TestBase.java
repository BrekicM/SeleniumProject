package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import pages.AuthPage;
import pages.IdentityPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyWishlistPage;

public class TestBase {
	WebDriver driver;
	ExcelReader excelReader;
	
	// pages
	MainPage mainPage;
	AuthPage authPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAdressesPage;
	IdentityPage identityPage;
	MyWishlistPage myWishlistPage;
	
	public void logIn(String email, String password) {
		mainPage.clickOnSignInButton();
		authPage.inputLoginEmail(email);
		authPage.inputPassword(password);
		authPage.clickSignInButton();
	}
	
	public void validLogIn() {
		mainPage.clickOnSignInButton();
		authPage.inputLoginEmail(excelReader.getCellData("TC1-Login", 5, 3));
		authPage.inputPassword(excelReader.getCellData("TC1-Login", 6, 3));
		authPage.clickSignInButton();
	}
		
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.excelReader = new ExcelReader("data/Testplan.xlsx");
		this.mainPage = new MainPage(driver);
		this.authPage = new AuthPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.myAdressesPage = new MyAddressesPage(driver);
		this.identityPage = new IdentityPage(driver);
		this.myWishlistPage = new MyWishlistPage(driver);
		driver.manage().window().maximize();
	}
		
	//@AfterClass
	public void afterClass() {
		driver.close();
	}
}
