package com.googletest.qa.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.googletest.qa.base.TestBase;

public class ReconTest extends TestBase {
	
	@BeforeMethod
	public void seTUp(){
		initialise();
	}
	
	@Test
	public void doesWebDriverWork(){
		driver.get("https://www.google.co.uk");
		//search page 
		WebDriverWait wait = new WebDriverWait(driver,10);
		String cssOfInputField = "input[name='q']";
		String cssOfInputFieldX = "//input[@name='q']";
		WebElement inputFieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfInputField)));
		WebElement inputFieldQX = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cssOfInputFieldX)));
		inputFieldQ.sendKeys("test");
		
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String cssOfSearchButton = "input[name='btnk']";
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cssOfSearchButton)));
		
		driver.findElement(By.xpath("//div[@class='sbtc']")).click();
		
		
		String xpathOfSearchButton = "//button[@class='Tg7LZd']";
		
		List<WebElement> resultEntries = driver.findElements(By.cssSelector("div.r a h3"));
		for(WebElement element : resultEntries){
			System.out.println(element.getAttribute("href"));
			System.out.println(element.getText());
		}
		
		List<WebElement> resultEntries1 = driver.findElements(By.cssSelector("div.r a"));
		for(WebElement element : resultEntries1){
			System.out.println(element.getAttribute("href"));
			System.out.println(element.getText());
		}
		
		driver.close();
		driver.quit();
		
		
		
		
	}
	
	
	

}
