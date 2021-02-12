package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTests extends TestBase{
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test
	public void addOneItemToCart() throws InterruptedException {
		addItemToCart();
		//Assert.assertEquals(shoppingCartPage.getOneItemInCartLabel().getText(), "Product successfully added to your shopping cart"
		//		); // testirati
	}
	
	//@Test
	public void addOneItemToCartAndIncreaseQuantity() {
		validLogIn();
		myAccountPage.clickOnHomeButton();
		mainPage.clickOnSecondProductImage();
		mainPage.clickShoppingCartButton();
		shoppingCartPage.clickPlusButton();
		shoppingCartPage.clickPlusButton();
		Assert.assertEquals(shoppingCartPage.getProductQuantityField().getText(), "3");
	}
	
	//@Test
	public void removeProductFromCart() throws InterruptedException {
		addItemToCart();
		shoppingCartPage.clickDeleteFromCartIcon();
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	public void addItemToCart() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions hover = new Actions(driver);
		
		validLogIn();
		myAccountPage.clickOnHomeButton();
		js.executeScript("window.scrollBy(0, 500)");
		hover.moveToElement(mainPage.getSecondProductImage()).perform();
		driver.findElement(By.xpath("//ul[@id='homefeatured']/li[2]/div/div/div[2]/a")).click();
		
		/*mainPage.clickOnSecondProductImage();
		itemPage.clickOnAddToCartButton();
		Thread.sleep(2000);
		itemPage.clickOnClosePopupWindow();
		itemPage.clickOnCartButton();*/
	}
}
