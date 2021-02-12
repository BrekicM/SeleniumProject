package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		Assert.assertEquals(shoppingCartPage.getNumberOfProductsInCart().getText(), excelReader.getCellData("TC5-ProductsToCart", 5, 3));
	}
	
	@Test
	public void addOneItemToCartAndIncreaseQuantity() throws InterruptedException {
		addItemToCart();
		shoppingCartPage.clickPlusButton();
		shoppingCartPage.clickPlusButton();
		Thread.sleep(3000);
		Assert.assertEquals(shoppingCartPage.getNumberOfProductsInCart().getText(), excelReader.getCellData("TC5-ProductsToCart", 12, 3));
	}
	
	@Test
	public void removeProductFromCart() throws InterruptedException {
		addItemToCart();
		shoppingCartPage.clickDeleteFromCartIcon();
		Thread.sleep(3000);
		Assert.assertEquals(shoppingCartPage.getCartEmptyLabel().getText(), excelReader.getCellData("TC5-ProductsToCart", 19, 3));
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
		mainPage.clickOnAddToCartButton();
		wait.until(ExpectedConditions.elementToBeClickable(mainPage.getProceedToCheckoutButton())).click();
	}
}
