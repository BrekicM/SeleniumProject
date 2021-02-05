package tests;

import org.testng.annotations.Test;

import tests.TestBase;

public class LogInTests extends TestBase{
	
	@Test
	public void logIn() {
		driver.navigate().to("http://cms.demo.katalon.com/");
	}
}
