package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		//String email = excelReader.getCellData("TC1-Login", 5, 3);
		//String password = excelReader.getCellData("TC1-Login", 6, 3);
		String myWishList1 = excelReader.getCellData("TC4-MyWishlist", 6, 3);
		validLogIn();		
		createWishList(myWishList1);
		Assert.assertEquals(true, myWishlistPage.getFirstWishlistLabel().isDisplayed());
		//System.out.println(myWishlistPage.getFirstWishlistLabel().getText());
	}
	
	@Test(priority = 10)
	public void addMultipleWishLists() {
		int i;
		validLogIn();
		myAccountPage.clickOnMyWishlistsButton();
		List<WebElement> numberOfWishlistsBeforeAdd = driver.findElements(By.xpath("//div[@id='block-history']/table/tbody/tr"));
		System.out.println(numberOfWishlistsBeforeAdd);
		for (i = 2; i < 6; i++) {
			createWishLists(excelReader.getCellData("TC4-MyWishlist", 11, 3) + i);
		}
		List<WebElement> numberOfWishlistsAfterAdd = driver.findElements(By.xpath("//div[@id='block-history']/table/tbody/tr"));
		System.out.println(numberOfWishlistsBeforeAdd);
		Assert.assertNotEquals(numberOfWishlistsBeforeAdd, numberOfWishlistsAfterAdd);
		/*if (numberOfWishlistsBeforeAdd != numberOfWishlistsAfterAdd) {
			System.out.println("Wishlists added.");
		}*/
		
		//tabela.findElements
	}
	
	@Test(priority = 15)
	public void deleteWishList() throws InterruptedException {
		validLogIn();
		myAccountPage.clickOnMyWishlistsButton();
		while (myWishlistPage.getRemoveButton().isDisplayed()) {
		myWishlistPage.clickRemoveButton();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		}
		Assert.assertEquals(false, myWishlistPage.getFirstWishlistLabel().isDisplayed());
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
	
	/*public void verifyNumberOfWishlists(int i) {
	List<WebElement> numberOfWishlists = driver.findElements(By.xpath("//div[@id='block-history']/table/tbody/tr"));
	if(numberOfWishlists.size() == i){
		 System.out.println(i + "wishlists are present");
		}
		else{
		 System.out.println("Incorrect number of wishlists present");
		}
	}*/
	
	/*public void assertSecondAddressNotPresent() {
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[@id='block-history']/table/tbody/tr/td/a"));
		if(dynamicElement.size() != 0){
			 System.out.println("Element present");
			}
			else{
			 System.out.println("Element not present");
			}
	} */
}
