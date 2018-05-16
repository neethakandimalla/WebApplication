package com.CapturingURl;

import org.openqa.selenium.firefox.FirefoxDriver;

public class URL_Facebook {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		
		String URL=driver.getCurrentUrl();
		
		System.out.println(URL);
		
		System.out.println(driver.getTitle());
		driver.close();

	}

}
