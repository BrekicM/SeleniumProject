package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistTests extends TestBase{
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void addWishList() {
		String myWishList1 = excelReader.getCellData("TC4-MyWishlist", 6, 3);
		validLogIn();		
		createWishList(myWishList1);
		Assert.assertEquals(true, myWishlistPage.getFirstWishlistLabel().isDisplayed());
	}
	
	@Test(priority = 10)
	public void addMultipleWishLists() {
		validLogIn();
		myAccountPage.clickOnMyWishlistsButton();
		int beforeAdd = myWishlistPage.getNumberOfWishlists().size();
		System.out.println(beforeAdd);
		for (int i = 2; i < 6; i++) {
			createWishLists(excelReader.getCellData("TC4-MyWishlist", 11, 3) + i);
			beforeAdd++;
		}
		int afterAdd = myWishlistPage.getNumberOfWishlists().size();
		System.out.println(afterAdd);
		Assert.assertEquals(afterAdd, beforeAdd);
	}
	
	@Test(priority = 15)
	public void deleteWishList() throws InterruptedException {			
		validLogIn();
		myAccountPage.clickOnMyWishlistsButton();
		int beforeDelete = myWishlistPage.getNumberOfWishlists().size();
		for (int i = 0; i < beforeDelete; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(myWishlistPage.getRemoveButton()));
			myWishlistPage.clickRemoveButton();
			//Thread.sleep(5000);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='block-history']/table/tbody/tr")));
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		}
		int afterDelete = myWishlistPage.getNumberOfWishlists().size();
		Assert.assertEquals(afterDelete, 0);
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	public void createWishList(String wishListName) {
		myAccountPage.clickOnMyWishlistsButton();
		myWishlistPage.clickWishlistNameField();
		myWishlistPage.getWishlistNameField().sendKeys(wishListName);
		myWishlistPage.clickSaveButton();
	}
	
	public void createWishLists(String wishListName) {
		myWishlistPage.clickWishlistNameField();
		myWishlistPage.getWishlistNameField().sendKeys(wishListName);
		myWishlistPage.clickSaveButton();
	}
}
