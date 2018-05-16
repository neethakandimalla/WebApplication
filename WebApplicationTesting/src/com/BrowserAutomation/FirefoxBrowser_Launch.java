package com.BrowserAutomation;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser_Launch
{

	public static void main(String[] args)
	{
		FirefoxDriver Neetha = new FirefoxDriver();
		
		Neetha.get("http://facebook.com");
		
		Neetha.navigate().to("http://google.com");
		
		Neetha.close();
		
	}

}
