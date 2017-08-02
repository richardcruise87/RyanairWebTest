package RyanairTestProject.Tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import RyanairTestProject.RyanairTest.pageObjects.RyanairPageObject_FlightSelect;

//////////////////////////////////////////////////////////////
//
//		Ryanair Flight Selection Page Test Object
//
//		Creates a page object of RyanairPageObject_FlightSelect class
//		Contains methods for interacting with Web Elements on this page
//
//////////////////////////////////////////////////////////////

public class RyanairTestObject_FlightSelect extends RyanairTestObject_Base {

	private RyanairPageObject_FlightSelect page;
	private String expectedPageTitle = "Ryanair";
	
	// Standard constructor
	public RyanairTestObject_FlightSelect(WebDriver driver) {
		this.driver = driver;
	}

	// Create the page object and check the page title is correct
	public void createPageObject()
	{
		page = new RyanairPageObject_FlightSelect(driver);
		
		String pageTitle = page.getPageTitle();
		
		// TODO: Fix this assertion
		//assertEquals(expectedPageTitle, pageTitle);
	}
	
	// Grab origin and destination airport texts and check them to ensure they are correct
	// Take 2 arguments which must be the expected origin and destination airport names
	public void checkOriginandDestination(String departureAirport, String destinationAirport)
	{
		// Get text element for origin/destination from page
		WebElement originAndDepartureElement = page.getOriginAndDestination();
		
		// Grab the string from this element
		String originAndDestination = originAndDepartureElement.getAttribute("innerText");
		
		String origin;
		String destination;
		
		// Split the string into the origin and destination airports
		String[] airports = originAndDestination.split(" to ");
		System.out.println("Airports = " + airports);
		
		origin = airports[0];
		destination = airports[1];
		
		// Check the ensure the airports names match the expected names
		assertEquals(origin, destinationAirport);
		assertEquals(destination, destinationAirport);
		
	}
	
	// Method for selecting outbound & inbound flights
	// TODO: Add ability to select different flight times and fare types, for now just select them statically
	public void selectFlights()
	{
		// Get the root element for the departure flight
		WebElement departureFlightRoot = page.getDepartureFlightRootElement();
		
		// Get the select button for that flight and click it
		WebElement departureFlightButton = page.getDepartureFlightElement();
		departureFlightButton.click();
		
		// Get the standard fare button and click it
		WebElement departureFareButton = page.getDepartureFareElement(departureFlightRoot);
		// Can take a moment for the button to enable so wait and check for it to be enabled
		while (departureFareButton.isEnabled() == false)
		{
			System.out.println("Waiting for Button to enable");
		}
		departureFareButton.click();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Get the root element for the return flight
		WebElement destinationFlightRoot = page.getDestinationFlightRootElement();
		
		// Get the select button for that flight and click it
		WebElement destinationFlightButton = page.getDestinationFlightElement();
		destinationFlightButton.click();
		
		// Get the standard fare button and click it
		WebElement destinationFareButton = page.getDestinationFareElement(destinationFlightRoot);
		// Can take a moment for the button to enable so wait and check for it to be enabled
		while (destinationFareButton.isEnabled() == false)
		{
			System.out.println("Waiting for Button to enable");
		}
		destinationFareButton.click();
		
		// Give the page a moment to update
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Get root element for continue button
		WebElement continueButtonRoot = page.getContinueButtonRoot();
		
		// Get the continue button and click it
		WebElement continueButton = page.getContinueButton(continueButtonRoot);
		// Can take a moment for the button to enable so wait and check for it to be enabled
		while (continueButton.isEnabled() == false)
		{
			System.out.println("Waiting for Button to enable");
		}
		continueButton.click();
				
	}
}
