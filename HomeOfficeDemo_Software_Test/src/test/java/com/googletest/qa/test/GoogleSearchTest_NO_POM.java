package com.googletest.qa.test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.googletest.qa.base.TestBase;

public class GoogleSearchTest_NO_POM extends TestBase{
	
	//WebDriverWait wait = new WebDriverWait(driver,30);
	
	//public GoogleSearchTest_NO_POM(){
		//super();
	//}
	
	@BeforeMethod
	public void setUp(){
		initialise();		
	}
	
	@Test
	public void googleSearchTest_No_Pom(){
		WebDriverWait wait = new WebDriverWait(driver,30);
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
	            .withTimeout( 20,TimeUnit.SECONDS)
	            .pollingEvery(20,TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);
		//.withTimeout(Duration.ofSeconds(20))
        //.pollingEvery(Duration.ofMillis(30000))
		//supported by Selenium 3.141.59
		 
	//Navigate to google serach page
	driver.get("https://www.google.co.uk");
	//Locate searchBox 
	WebElement searchchBox = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
	   //Enter a text in the SearchBox
	searchchBox.sendKeys("Adaptavist");
	   //Wait for the avialability of this element before performing the next actions
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tsf']/div[2]/div/div[2]/div[2]/div/center/input[1]")));
	
	//Capture all the listed options 
	//List<WebElement> resultList = driver.findElements(By.cssSelector("div.sbct"));
	/**List<WebElement> list = driver.findElements(By.xpath("//div[@class='sbtc']"));	 
	for(int i= 0; i<list.size(); i++){
		System.out.println("print the searchResult " + list.get(i).getText());
		//if(list.get(i).getText().equalsIgnoreCase(text)){
			//list.get(i).click();
		//	break;
		//}
	}**/
	
	
	List<WebElement> resultList = driver.findElements(By.xpath("//div[@class='sbtc']"));
    for(WebElement element : resultList){
		System.out.println("print the searchResult " + element.getText());
		if(element.getText().equalsIgnoreCase("Adaptavist")){
			element.click();
			break;
		}
	}
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='r']/a/h3"));
   /** for(WebElement elmt : searchResult){
    	if(elmt.getText().contains("Adaptavist")){
    	elmt.click();
    	try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.navigate().back();
    	try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	searchResult = driver.findElements(By.xpath("//div[@class='r']/a/h3"));
    	 
    } ***/
    
   for(int i=0; i<searchResult.size();i++){
		if(searchResult.get(i).getText().contains("Adaptavist")){
			searchResult.get(i).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//getScreenShot(i);
			//get screen shoot and navigate back
			driver.navigate().back();
		}
		 searchResult = driver.findElements(By.xpath("//div[@class='r']/a/h3"));
	}
    
    
   /**for(WebElement elmt : searchResult){
 		if(elmt.getText().contains("Adaptavist")){
 			elmt.click();
 			try {
 				Thread.sleep(2000);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			//getScreenShot(i);
 			//get screen shoot and navigate back
 			driver.navigate().back();
 		}
 		 searchResult = driver.findElements(By.xpath("//div[@class='r']/a/h3"));
 	}***/
    
    
    
    
    
    
    
    /**
	List<WebElement> resultList = driver.findElements(By.xpath("//div[@class='sbtc']"));	 
	for(WebElement ele : resultList ){
		System.out.println("print the searchResult " + ele.getText());
		//if(list.get(i).getText().equalsIgnoreCase(text)){
			//list.get(i).click();
		//	break;
		//}
	}***/		
		
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
