package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumWrappers;

public class GenericEventPage extends SeleniumWrappers{

	
	public WebDriver driver;
	
	public GenericEventPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By mapFrame = By.tagName("iframe");
	public By viewLargerMapLink = By.linkText("View larger map");
	
}
