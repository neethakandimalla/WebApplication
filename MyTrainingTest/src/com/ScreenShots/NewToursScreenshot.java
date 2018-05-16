package com.ScreenShots;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewToursScreenshot
{

	public static void main(String[] args) throws IOException
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		File Scrn=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Scrn,new File("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\MyTrainingTest\\src\\com\\ScreenShots\\ScreenShotNewTours\\tours.png"));
		
		List<WebElement>link=driver.findElementsByTagName("a");
		System.out.println(link.size());
		
		for(int i=0;i<link.size();i++)
		{
			String title=link.get(i).getText();
			System.out.println(i+". "+title);
			link.get(i).click();
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			System.out.println();
			
			File Scrn1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Scrn1,new File("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\MyTrainingTest\\src\\com\\ScreenShots\\ScreenShotNewTours\\"+i+"_"+title+".png"));
			
			driver.navigate().back();
			
			link=driver.findElementsByTagName("a");
			
			
		}
		
		
		driver.close();


	}

}
