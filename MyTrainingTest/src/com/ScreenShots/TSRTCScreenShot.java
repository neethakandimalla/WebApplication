package com.ScreenShots;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TSRTCScreenShot 
{
	public static void main(String[] args) throws  InterruptedException
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.tsrtconline.in/oprs-web/");
		
		List <WebElement> link=driver.findElementsByTagName("a");
		System.out.println(link.size());
				
		for(int i=0;i<link.size();i++)
		{
		 String link_title=link.get(i).getText();
		 
		 System.out.println(i+". "+link_title);
		 
		/* link.get(i).click();
		 
		 System.out.println(driver.getTitle());
		 
		 System.out.println(driver.getCurrentUrl());
		 
		 System.out.println();
		 
		 /*File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(source,new File(" C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\MyTrainingTest\\src\\com\\ScreenShots\\TSRTCScreenShots\\"+link_title+".png"));*/ 
		 
		// driver.navigate().back();
		// Thread.sleep(5000);
		 //Sleeper.sleepTightInSeconds(5);
		
		// link = driver.findElementsByTagName("a");
				 
		}
				
		driver.close();

}
	
}
