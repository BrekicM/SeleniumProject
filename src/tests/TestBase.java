package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;

public class TestBase {
	WebDriver driver;
	MainPage mainPage;
	AuthPage authPage;
	ExcelReader excelReader;
	MyAccountPage myAccountPage;
	MyAddressesPage myAdressesPage;
	
	public void logIn(String email, String password) {
		mainPage.clickOnSignInButton();
		authPage.inputLoginEmail(email);
		authPage.inputPassword(password);
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
		driver.manage().window().maximize();
	}
		
	@AfterClass
	public void afterClass() {
		driver.close();

	}
}
