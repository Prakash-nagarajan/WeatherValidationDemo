package com.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.apiCalls.CallWeatherApi;

public class DriverUtils extends Driver {
	
	public void waitForElement(By ele){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	protected void clickElement(By ele){
		waitForElement(ele);
		driver.findElement(ele).click();
	}
	
	protected String readProp(String city) throws IOException{
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\weatherDemo.properties");
		obj.load(objfile);
		String tempProp = obj.getProperty(city);
		return tempProp;
	}
	
	protected void search(By ele, String cityName){
		waitForElement(ele);
		driver.findElement(ele).sendKeys(cityName);
		driver.findElement(ele).sendKeys(Keys.ENTER);
	}
	
	protected int getWeatherFromUi(By ele){ // Reading weather from UI
		String temperatureInFahrenheit=driver.findElement(ele).getText();
		temperatureInFahrenheit=temperatureInFahrenheit.substring(temperatureInFahrenheit.lastIndexOf(" ")+1);
		double temperatureInKelvi = (((Integer.parseInt(temperatureInFahrenheit))-32)*5/9 + 273.15);
//				Formula to convert - (97°F − 32) × 5/9 + 273.15
		System.out.println("Temp from UI.....    "+temperatureInKelvi);
		return (int)temperatureInKelvi;
	}
	
	protected String getWeatherFromApiCall(String city){ //Reading weather from API
		return CallWeatherApi.getWeatherFromApi(city);
	}
	protected void assertUiVsApiWeather(String city, By ele){
		Assert.assertEquals(getWeatherFromUi(ele), (int)Double.parseDouble(getWeatherFromApiCall(city)));	//We are ignoring the decimal point	
	}
	
}
