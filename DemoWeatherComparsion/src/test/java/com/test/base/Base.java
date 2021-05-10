package com.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base extends PageFactory{

	WebDriver driver;

	@BeforeTest
	public void start(){
		intentiate();
		launch();
	}

	public void intentiate(){
		driver = Driver.getDriverInstance();
		init();
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
