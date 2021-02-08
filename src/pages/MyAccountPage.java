package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAccountPageLabel;
	WebElement myAddressesButton;
	
	public MyAccountPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getMyAccountPageLabel() {
		return driver.findElement(By.className("page-heading"));
	}

	public WebElement getMyAddressesButton() {
		return driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]/a/span"));
	}
	
	public void clickOnMyAddressesButton() {
		getMyAddressesButton().click();
	}
	
	
	
}
