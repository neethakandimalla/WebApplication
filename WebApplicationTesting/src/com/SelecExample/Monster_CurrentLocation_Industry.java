package com.SelecExample;

import org.jboss.netty.channel.FixedReceiveBufferSizePredictorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Monster_CurrentLocation_Industry {

	public static void main(String[] args)
	{
		FirefoxDriver driver  = new FirefoxDriver();
		driver.get("http://my.monsterindia.com/sponsered_popup.html");
		
		WebElement CurrentLocation=driver.findElement(By.className("border_grey1"));
		
		Select selection = new Select(CurrentLocation);
		//selection.selectByIndex(2);
		//selection.selectByValue("2");
		selection.selectByVisibleText("Delhi");
		
		WebElement industry=driver.findElement(By.id("id_industry"));
		
		Select selection1 = new Select(industry);
		selection1.selectByIndex(2);
		selection1.selectByValue("5");
		selection1.selectByVisibleText("Any");
		

	}

}
