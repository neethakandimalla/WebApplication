package com.MyBasics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FrontierTest 
{

	public static void main(String[] args)
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://frontierutilities.com");
		driver.findElementByClassName("dropdown-toggle").getText();
		driver.findElementByLinkText("Create an account").click();
	}

}
