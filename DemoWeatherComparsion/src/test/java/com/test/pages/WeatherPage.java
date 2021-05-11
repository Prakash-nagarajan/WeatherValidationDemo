package com.test.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.test.base.DriverUtils;

public class WeatherPage extends DriverUtils {

	private static By notNow = By.xpath("//a[text()='No Thanks']");
	private static By extendTopMenu = By.xpath("//div/a[@class='topnavmore']");
	private static By Weather = By.xpath("//div/a[text()='WEATHER']");
	private static By searchCity = By.id("searchBox");
	private static By listRajkot = By.xpath("//input[@id='Rajkot']");	
	private static By delhiToLoad = By.xpath("//div[text()='New Delhi']");
	private static By cityRajkot = By.xpath("//div[text()='Rajkot']");
	private static By Temp = By.xpath("//div/span/b[contains(text(),'Temp in Fahrenheit:')]");

	public void verifyMyCityWeather() throws IOException{
		clickElement(notNow);
		clickElement(extendTopMenu);
		clickElement(Weather);
		search(searchCity,readProp("city"));
		waitForElement(delhiToLoad);
		clickElement(listRajkot);
		clickElement(cityRajkot);
		assertUiVsApiWeather(readProp("city"),Temp); //Note: Assertion is failing since mismatch between API data and UI data
	}

}
