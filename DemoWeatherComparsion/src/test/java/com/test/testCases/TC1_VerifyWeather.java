package com.test.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.test.base.PageFactory;

public class TC1_VerifyWeather extends PageFactory{

	@Test
	public void searchCity() throws IOException{
		getPageObjects().verifyMyCityWeather();
	}
}
