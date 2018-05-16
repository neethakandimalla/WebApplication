package newToursApplicationTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewToursLogInTest 
{

	FirefoxDriver driver;

	
	@Given("^Open Firefox Browser and Navigate to NewTours Application$")
	public void Open_Firefox_Browser_and_Navigate_to_NewTours_Application() 
	{
		 driver = new FirefoxDriver();
			driver.get("http://newtours.demoaut.com");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	}

	/*@When("^User enters valid UserName and Password and Click on SignIn button$")
	public void User_enters_valid_UserName_and_Password_and_Click_on_SignIn_button()
	{
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
	}*/
	
	@When("^User enters valid \"([^\"]*)\" and \"([^\"]*)\" and Click on SignIn button$")
	public void User_enters_valid_and_and_Click_on_SignIn_button(String UserName, String Password)  
	{
		driver.findElement(By.name("userName")).sendKeys(UserName);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("login")).click();
	   
	}

	@Then("^user should be able to successfully logIn and close the application$")
	public void user_should_be_able_to_successfully_logIn_and_close_the_application()
	{

		String expected_Title="Find";
		String actual_Title=driver.getTitle();
		
		if(actual_Title.contains(expected_Title))
		{
			System.out.println("Title Matched -- LogIn Successful -- PASS");
		}
		else
		{
			System.out.println("Title not Matched -- LogIn Failed -- FAIL");
		}
		
		driver.close();
	}
	
	
	
	
	
}
