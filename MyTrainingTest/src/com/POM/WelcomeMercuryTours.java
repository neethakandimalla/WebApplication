package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomeMercuryTours 
{
	@FindBy(linkText="Home")
	WebElement home;
	
	public void home()
	{
		home.click();
	}
	
	@FindBy(linkText="Flights")
	WebElement  flights;
	
	public void flight()
	{
		flights.click();
	}
	
	@FindBy(linkText="Hotels")
	WebElement hotels;
	
	public void hotel()
	{
		hotels.click();
	}
	
	@FindBy(linkText="Car Rentals")
	WebElement carRent;
	
	public void carrental()
	{
		carRent.click();
	}
	
	@FindBy(linkText="Cruises")
	WebElement cruise;
	
	public void cruise()
	{
		cruise.click();
	}
	
	@FindBy(linkText="Destinations")
	WebElement destination;
	
	public void destinations()
	{
		destination.click();
	}
	

	@FindBy(linkText="Vacations")
	WebElement vacation;
	
	public void vacation()
	{
		vacation.click();
	}
	
	@FindBy(linkText="your destination")
	WebElement yourDest;
	
	public void yourdestination()
	{
		yourDest.click();
	}
	
	@FindBy(linkText="featured vacation destinations")
	WebElement vacationDest;
	
	public void featuredVacDest()
	{
		vacationDest.click();
	}
	
	@FindBy(linkText="Register here")
	WebElement RegiHere;
	
	public void registerHere()
	{
		RegiHere.click();
	}
	
	
	@FindBy(linkText="Business Travel @ About.com")
	WebElement BusiTravelAbout;
	
	public void businessTravel()
	{
		BusiTravelAbout.click();
	}
	
	@FindBy(linkText="Salon Travel")
	WebElement salonTra;
	
	public void salonTravel()
	{
		salonTra.click();
	}
	
	
	
	

}
