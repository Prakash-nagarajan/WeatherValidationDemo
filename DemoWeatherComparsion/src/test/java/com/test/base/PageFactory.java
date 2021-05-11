package com.test.base;

import com.test.pages.WeatherPage;

public class PageFactory {
	
	protected static WeatherPage weatherPageObj;
	
	public static void init(){
		weatherPageObj = new WeatherPage();
	}
	
	public static WeatherPage getPageObjects(){
		return weatherPageObj;
	}

}
