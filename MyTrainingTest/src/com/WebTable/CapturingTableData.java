package com.WebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CapturingTableData
{

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement table=driver.findElement(By.xpath("html/body/div[1]/div[8]/section[2]/div[1]/table"));
		List <WebElement>Rows=table.findElements(By.tagName("tr"));
		for(int i=0;i<Rows.size();i++)
		{
			List<WebElement> cells=Rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cells.size();j++)
			{
				String data=cells.get(j).getText();
				System.out.println(data+"  ");
			}
			System.out.println();
		}
		
		
		
		

	}

}
