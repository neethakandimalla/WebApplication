package com.Annotations;

import org.testng.annotations.Test;

public class Annotations1 
{

	@Test(priority=1)
	public void BrowserLaunch()
	{
		System.out.println("FireFox Browser Launch");
	}
	
	@Test(priority=2)
	public void LogIn()
	{
		System.out.println("LogIN Test");
	}
	
	@Test(priority=3)
	public void InBox()
	{
		System.out.println("InBox Funcationality Testing");
	}
	
	@Test(enabled=false)
	public void ComposeMail()
	{
		System.out.println("Compose Mail Funcationality Testing");
	}
	
	
}
