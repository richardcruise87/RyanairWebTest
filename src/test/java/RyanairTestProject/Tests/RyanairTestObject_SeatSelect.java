package RyanairTestProject.Tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import RyanairTestProject.RyanairTest.pageObjects.RyanairPageObject_SeatSelect;

//////////////////////////////////////////////////////////////
//
//		Ryanair Seat Selection Page Test Object
//
//		Creates a page object of RyanairPageObject_SeatSelect class
//		Contains methods for interacting with Web Elements on this page
//
//////////////////////////////////////////////////////////////

public class RyanairTestObject_SeatSelect extends RyanairTestObject_Base {

	private RyanairPageObject_SeatSelect page;
	private String expectedPageTitle = "Ryanair";
	
	// Standard constructor
	public RyanairTestObject_SeatSelect(WebDriver driver) {
		this.driver = driver;
	}
	
	// Create the page object and check the page title is correct
	public void createPageObject()
	{
		page = new RyanairPageObject_SeatSelect(driver);
		
		String pageTitle = page.getPageTitle();
		
		// TODO: Fix this assertion
		//assertEquals(expectedPageTitle, pageTitle);
	}
	
	// Close any popup windows that appear
	public void closePopUp()
	{
		WebElement popUpCloseButton = page.getPopUpButtonElement();
		
		popUpCloseButton.click();
	}	
	
	// Method to select outbound & return seats
	// Take 1 argument which is total number of passengers
	// TODO: Add ability to select particular seats and different seat types, for mow just randomly select seats
	// TODO: Break up into smaller methods
	public void selectAvailableSeats(int passengers)
	{
		System.out.println("Searching for " + passengers + " seats");
		
		WebElement seatSearchRoot;
		Iterator<WebElement> iterator;
		WebElement selectedSeat;
		
		// Get root element for seat selection menu
		seatSearchRoot = page.getSeatSelectionRootElement();
		
		// Get a list object of all available seats
		ArrayList<WebElement> availableOutboundSeatElements = page.getAvailableSeatElements(seatSearchRoot);
		iterator  = availableOutboundSeatElements.iterator();
		
		System.out.println("Found " + availableOutboundSeatElements.size() + " available seats");
		
		// For each passenger, iterate through available seats and click one for each passenger
		for(int i=0; i<=passengers; i++)
		{
			selectedSeat = availableOutboundSeatElements.get(i);
			selectedSeat.click();
		}
		
		// Grab the continue button and click it
		WebElement continueButtonRoot = page.getContinueButtonRootElement();
		WebElement continueButton = page.getContinueButtonElement(continueButtonRoot);
		continueButton.click();
		
		// Sometime a popup appears asking if we want the same seats for the return flight
		// Find button to dismiss popup and click it
		WebElement differentSeatButtonRoot = page.getDifferentSeatRootElement();
		
		ArrayList<WebElement> pickDifferentSeatsElements = page.getDifferentSeatElements(differentSeatButtonRoot);
		iterator  = pickDifferentSeatsElements.iterator();
		
		WebElement differentSeatButton;
		while(iterator.hasNext())
		{
			System.out.println("Found a different seat button!");
			differentSeatButton = (WebElement) iterator.next();
			System.out.println(differentSeatButton.getAttribute("translate"));
			while (differentSeatButton.isEnabled() == false)
			{
				System.out.println("Waiting for Button to enable");
			}
			differentSeatButton.click();
		}
		
		// Get root element for seat selection menu
		seatSearchRoot = page.getSeatSelectionRootElement();
		
		// Get a list object of all available seats
		ArrayList<WebElement> availableInboundSeatElements = page.getAvailableSeatElements(seatSearchRoot);
		iterator  = availableOutboundSeatElements.iterator();
		
		System.out.println("Found " + availableInboundSeatElements.size() + " available seats");
		
		// For each passenger, iterate through available seats and click one for each passenger
		for(int i=0; i<=passengers; i++)
		{
			selectedSeat = availableInboundSeatElements.get(i);
			selectedSeat.click();
		}

		// Grab the continue button and click it
		continueButtonRoot = page.getContinueButtonRootElement();
		continueButton = page.getContinueButtonElement(continueButtonRoot);
		continueButton.click();
	}
	
}
