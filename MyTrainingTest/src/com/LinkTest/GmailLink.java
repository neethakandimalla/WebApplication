package com.LinkTest;

import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLink 
{

	public static void main(String[] args)
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com/gmail/about/");
		driver.findElementByLinkText("html/body/nav/div/a[2]").click();

	}

}
