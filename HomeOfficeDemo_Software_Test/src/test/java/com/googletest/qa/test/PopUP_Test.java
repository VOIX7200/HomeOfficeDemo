package com.googletest.qa.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.googletest.qa.base.TestBase;

public class PopUP_Test extends TestBase {
	
	@BeforeMethod
	public void setUp(){
		
		initialise();
		
	}
	@Test
	public void closePopUp_Test(){
		driver.get("http://127.0.0.1:8080");
		
		Alert al = driver.switchTo().alert();
		//isAlertPresent();
		
	for(int i=0; i<5; i++){
			
		if(isAlertPresent()){
			al.accept();
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
		al = driver.switchTo().alert();
		
	}
	if(isAlertPresent()){
		al.accept();
		
	}
	   	
	//Alert al = driver.switchTo().alert().accept();
		 
		//driver.switchTo().alert().accept();
		//for(int i =0; i<4; i++){
		//if(al.equals(true))
		//al.accept();
		//}
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	public boolean isAlertPresent() {

		  boolean presentFlag = false;

		  try {

		   // Check the presence of alert
		   Alert alert = driver.switchTo().alert();
		   // Alert present; set the flag
		   presentFlag = true;
		   // if present consume the alert
		 // alert.accept();

		  } catch (NoAlertPresentException ex) {
		   // Alert not present
		   ex.printStackTrace();
		  }

		  return presentFlag;

		 }

}
