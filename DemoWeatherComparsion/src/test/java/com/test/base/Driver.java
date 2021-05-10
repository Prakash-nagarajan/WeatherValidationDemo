package com.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	protected static WebDriver driver;
	
	public static WebDriver getDriverInstance(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

}
