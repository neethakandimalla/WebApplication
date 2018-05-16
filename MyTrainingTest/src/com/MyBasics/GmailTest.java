package com.MyBasics;


import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailTest
{

	public static void main(String[] args) throws InterruptedException
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://google.com");
		driver.get("gmail.com");
		
		Thread.sleep(10000);
		driver.findElementByLinkText("Sign In").click();
		//driver.findElementByClassName("gmail-nav__nav-link gmail-nav__nav-link__sign-in").click();
		//driver.findElement(By.linkText("Create an account")).click();
		driver.close();
				
				

	}

}
