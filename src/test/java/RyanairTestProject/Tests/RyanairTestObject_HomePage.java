package RyanairTestProject.Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import RyanairTestProject.RyanairTest.pageObjects.RyanairPageObject_HomePage;

//////////////////////////////////////////////////////////////
//
//		Ryanair Home Page Test Object
//
//		Creates a page object of RyanairPageObject_HomePage class
//		Contains methods for interacting with Web Elements on this page
//
//////////////////////////////////////////////////////////////

public class RyanairTestObject_HomePage extends RyanairTestObject_Base {
	
	private RyanairPageObject_HomePage page;
	private String expectedPageTitle = "Official Ryanair website | Cheap flights from Ireland | Ryanair";
	
	public RyanairTestObject_HomePage(WebDriver driver) {
		this.driver = driver;
	}	
	
	// Create the page object and ensure the title is correct
	public void createPageObject()
	{
		page = (RyanairPageObject_HomePage) new RyanairPageObject_HomePage(driver);
		
		String pageTitle = page.getPageTitle();
		
		assertEquals(expectedPageTitle, pageTitle);
	}
	
	// Select departure airport, input string must be valid airport name
	public void inputDepartureAirport(String departureAirportName)
	{
		// Get airport text box and input airport name
		WebElement departureAirportElement = page.getDepartureAirportElement();
		departureAirportElement.sendKeys(departureAirportName);
		
		// Need to click the correct airport to ensure page responds correctly
		WebElement departureAirportMenuElement = page.getDepartureAirportMenuElement();
		departureAirportMenuElement.click();
		
		// Check the airport input is correct
		// TODO: Fix this assertion
		String inputText = departureAirportElement.getText();
		//assertEquals(departureAirportName, inputText);
	}
	
	// Select destination airport, input string must be valid airport name
	public void inputDestinationAirport(String destinationAirportName)
	{
		// Get airport text box and input airport name
		WebElement destinationAirportElement = page.getDestinationAirportElement();
		destinationAirportElement.sendKeys(destinationAirportName);
		
		// Need to click the correct airport to ensure page responds correctly
		WebElement destinationAirportMenuElement = page.getDestinationAirportMenuElement();
		destinationAirportMenuElement.click();
		
		// Check the airport input is correct
		// TODO: Fix this assertion
		String inputText = destinationAirportElement.getText();
		//assertEquals(destinationAirportName, inputText);
	}
	
	// Select departure date, input string must be date in the form dd/mm/yyyy
	public void inputDepartureDate (String departureDate)
	{
		// Get the date text box and menu item
		//WebElement[] departureDateElement = page.getDepartureDateElement();
		WebElement departureDateMenuElement = page.getDepartureDateMenuElement();
		
		// Input the date string to text boxes
		// TODO: Figure out why this doesn't work
		//departureDateElement[2].clear();;
		//departureDateElement[2].sendKeys(departureDate.substring(6, 10));
		//departureDateElement[2].clear();;
		//departureDateElement[1].sendKeys(departureDate.substring(3, 5));
		//departureDateElement[2].clear();;
		//departureDateElement[0].sendKeys(departureDate.substring(0, 2));

		// Click date menu item
		// TODO: Add ability to find correct date, just use static date for the moment
		departureDateMenuElement.click();
	}
	
	// Select return date, input string must be date in the form dd/mm/yyyy
	public void inputReturnDate (String returnDate)
	{
		// Get the date text box and menu item
		//WebElement[] returnDateElement = page.getReturnDateElement();
		WebElement returnDateMenuElement = page.getReturnDateMenuElement();
		
		// Input the date string to text boxes
		// TODO: Figure out why this doesn't work
		//returnDateElement[2].clear();
		//returnDateElement[2].sendKeys(returnDate.substring(6, 10));
		//returnDateElement[1].clear();
		//returnDateElement[1].sendKeys(returnDate.substring(3, 5));
		//returnDateElement[0].clear();
		//returnDateElement[0].sendKeys(returnDate.substring(0, 2));
		
		// Click date menu item
		// TODO: Add ability to find correct date, just use static date for the moment
		returnDateMenuElement.click();
	}

	// Input number of passengers, takes 4 arguments for number of adults, teens, children & infants
	public void addPassengers(int adults, int teens, int children, int infants)
	{
		// Get the passenger menu element
		WebElement passengerMenuElement = page.getPassengerMenuElement();
		
		// Click the element to bring up the dropdown menu
		passengerMenuElement.click();
		
		// Get the plus and minus buttons from the dropdown menu
		// TODO: Add other buttons when getter methods available
		WebElement adultPlusButton = page.getPassengerMenuAdultPlusElement();
		WebElement childPlusButton = page.getPassengerMenuChildrenPlusElement();
		
		// Click the plus button for each passenger type
		// There's one adult selected by default, so reduce that number by one
		for(int i=0; i<adults-1; i++)
		{
			adultPlusButton.click();
		}
		
		for(int i=0; i<children; i++)
		{
			childPlusButton.click();
		}
	}
	
	// Click button to search for flights
	public void searchFlights()
	{
		WebElement searchButton = page.getSearchButton();

		searchButton.click();
		
	}
	
	// Sometimes pop-up windows appear, find the close buttons for these windows and click them
	public void closePopUps()
	{
		ArrayList<WebElement> popUpCloseButtons = (ArrayList<WebElement>) page.getPopCloseButtons();
		Iterator iterator = popUpCloseButtons.iterator();
		WebElement closeButton;
		
		while(iterator.hasNext())
		{
			System.out.println("Found a close button!");
			closeButton = (WebElement) iterator.next();
			closeButton.click();
		}
		
	}
}
