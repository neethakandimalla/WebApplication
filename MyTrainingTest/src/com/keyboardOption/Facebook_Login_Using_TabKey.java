package com.keyboardOption;

import java.awt.Desktop.Action;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Facebook_Login_Using_TabKey {

	public static void main(String[] args) 
	{
	
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("Helloo");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys("hiiiii").build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		
		

	}

}
