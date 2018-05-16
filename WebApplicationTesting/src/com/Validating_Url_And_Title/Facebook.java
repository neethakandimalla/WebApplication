package com.Validating_Url_And_Title;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Facebook {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		String expected_Title="Facebook - Log In or Sign Up";
		String actual_Title=driver.getTitle();
		
		System.out.println(expected_Title);
		System.out.println(actual_Title);
		
		if(actual_Title.equals(expected_Title))
		{
			System.out.println("TItle Matched -- PASS");
		}
		else
		{
			System.out.println("Title Not matched -- Fail");
		}
		
		String expected_Url = "facebook.com";
		String actual_Url = driver.getCurrentUrl();
		
		System.out.println(expected_Url);
		System.out.println(actual_Url);
		
		if(actual_Url.contains(expected_Url))
		{
			System.out.println("Url matched -- PASS");
		}
		else
		{
			System.out.println("Url not matched -- FAIL");
		}

		driver.close();
	}

}
