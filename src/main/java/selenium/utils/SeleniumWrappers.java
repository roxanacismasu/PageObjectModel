package selenium.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest{

	
	
	//Weblement element = driver.findElement(locator);
	//element.click();
	
	
	public void click(By locator) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration. ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement element = driver.findElement(locator);
			element.click();
			
		}catch(NoSuchElementException e) {
			
			
		}
		
		//driver.findElement(locator).click();
		
	}
	
	public void sendKeys(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
		
	}
	
	
	public void hoverElement(By locator) {
		
		try {
			WebElement element = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			
			
		}catch(Exception e) {
			new TestException(e.getMessage());
		}	
	}
	
	
	public void dragAndDrop(By locator, int x, int y) {
		try {
			Actions action = new Actions(driver);
		
			action
				.moveToElement(getWebElement(locator))
				.clickAndHold()
				.moveByOffset(x, y)
				.release()
				.perform();
			//action.dragAndDropBy(getWebElement(locator), x, y).perform();			
			
		}catch(Exception e) {
			new TestException(e.getMessage());
		}	
	}
	
	
	
	
	public WebElement getWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public void scrollVertically(int pixels) {
		Actions action =  new Actions(driver);
		action.scrollByAmount(0, pixels).perform();
	}
	
	public void scrollHorizontally(int pixels) {
		Actions action =  new Actions(driver);
		action.scrollByAmount(pixels, 0 ).perform();
	}
	
}
