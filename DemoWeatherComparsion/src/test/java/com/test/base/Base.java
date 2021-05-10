package com.test.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Base{
	
	WebDriver driver;
	
	@Test
	public void start(){
		intentiate();
		launch();
	}
	
	public void intentiate(){
		driver = Driver.getDriverInstance();
	}
	
	public void launch(){
		driver.get("https://ndtv.com");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void close(){
//		driver.quit();
	}

}
