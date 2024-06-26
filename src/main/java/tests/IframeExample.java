package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pageObjects.MenuPage;
import selenium.utils.BaseTest;

public class IframeExample extends BaseTest{

	
	@Test
	public void iframeTest() throws InterruptedException {
		
		app.click(app.menu.contactsLink);
		
		driver.switchTo().frame(app.getWebElement(app.contacts.mapFrame));
		
		app.click(app.contacts.zoomInBtn);
		Thread.sleep(2000);
		app.click(app.contacts.zoomInBtn);

		driver.switchTo().defaultContent();
		app.sendKeys(app.contacts.nameField, "TEST TEST"); 
		
		
		//drag and drop map
		driver.switchTo().frame(app.getWebElement(app.contacts.mapFrame));
		app.click(app.contacts.zoomInBtn);
		Thread.sleep(2000);
		app.click(app.contacts.zoomInBtn);

		
		//drag and drop map
		Actions action  =  new Actions(driver);
		
		action
			.moveToElement(app.getWebElement(By.cssSelector("div[aria-label='Map']")))
			.clickAndHold()
			.pause(Duration.ofSeconds(2))
			.moveByOffset(-50, -50)
			.moveByOffset(-50, -50)
			.pause(Duration.ofSeconds(2))
			.release()
			.perform();
		
		
		
	}
	
	
	
}
