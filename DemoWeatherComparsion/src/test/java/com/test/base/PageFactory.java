package com.test.base;

import com.test.pages.HomePage;

public class PageFactory {
	
	protected static HomePage hmePageObj;
	
	public static void init(){
		hmePageObj = new HomePage();
	}
	
	public static HomePage getPageObjects(){
		return hmePageObj;
	}

}
