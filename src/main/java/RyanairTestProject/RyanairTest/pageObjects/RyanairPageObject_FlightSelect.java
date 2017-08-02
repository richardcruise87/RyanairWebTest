package RyanairTestProject.RyanairTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//////////////////////////////////////////////////////////////
//
//	Ryanair Flight Selection Page Object Class
//
//	Page Object Class for all Ryanair Flight Selection WebElements
//	Contains methods to return WebElements used by Test cases
//
//////////////////////////////////////////////////////////////

public class RyanairPageObject_FlightSelect extends RyanairPageObject_Base {

	// String variables to store search criteria for Web Elements
	// Putting them as class variables now to make editing easier
	private String departureFlightId = "flight-FR~ 120~ ~~DUB~09/04/2017 06:30~LGW~09/04/2017 08:05~";
	private String departureFlightXPath = ".//*[@id='flight-FR~ 120~ ~~DUB~09/04/2017 06:30~LGW~09/04/2017 08:05~']/div/div[2]/flights-table-price/div/div";
	private String departureFareXPath = "//div[contains(@class, 'flights-table-fares__fare standard mandatory-seat')]";
	private String departureFareButtonXPath = "//button[contains(@id, 'continue')]";
	
	private String destinationFlightId = "flight-FR~ 119~ ~~LGW~09/11/2017 21:35~DUB~09/11/2017 22:55~";
	private String destinationFlightXPath = ".//*[@id='flight-FR~ 119~ ~~LGW~09/11/2017 21:35~DUB~09/11/2017 22:55~']/div/div[2]/flights-table-price/div/div";
	private String destinationFareXPath = "//div[contains(@class, 'flights-table-fares__fare standard mandatory-seat')]";
	private String destinationFareButtonXPath = "//button[contains(@id, 'continue')]";
	
	private String continueButtonRootXPath = ".//*[@id='booking-results']/div/div/div[3]";
	private String continueButtonXPath = "//button[contains(@id, 'continue')]";
	
	// Standard constructor
	// Don't need to navigate to page as test case will handle that for us
	public RyanairPageObject_FlightSelect(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Grab text element containing origin and destination airports
	public WebElement getOriginAndDestination()
	{
		WebElement element = super.driver.findElement(By.className("destination"));
		
		return element;
	}

	// Return Web Element for flight we want to select
	// Will use this as point to search for child elements
	// TODO: Add option to select different flights
	public WebElement getDepartureFlightRootElement ()
	{
		WebElement element = super.driver.findElement(By.id(departureFlightId));
		
		return element;
	}
	
	// Return web element to select departure flight
	public WebElement getDepartureFlightElement ()
	{
		WebElement element = super.driver.findElement(By.xpath(departureFlightXPath));
		
		return element;
	}

	// Return Standard seat selection button for selected flight
	// Takes a WebElement which is the parent for that particular flight
	public WebElement getDepartureFareElement (WebElement parentElement)
	{

		WebElement element = parentElement.findElement(By.xpath(departureFareXPath));
		
		WebElement subElement = element.findElement(By.xpath(departureFareButtonXPath));
		
		return subElement;
	}
	
	// TODO: Add selection methods for different fare types
	
	// Return Web Element for flight we want to select
	// Will use this as point to search for child elements
	// TODO: Add option to select different flights	
	public WebElement getDestinationFlightRootElement ()
	{
		WebElement element = super.driver.findElement(By.id(destinationFlightId));
		
		return element;
	}
	
	// Return web element to select departure flight
	public WebElement getDestinationFlightElement ()
	{
		WebElement element = super.driver.findElement(By.xpath(destinationFlightXPath));
		
		return element;
	}

	// Return Standard seat selection button for selected flight
	// Takes a WebElement which is the parent for that particular flight
	public WebElement getDestinationFareElement (WebElement parentElement)
	{
		WebElement element = parentElement.findElement(By.xpath(destinationFareXPath));
		
		WebElement subElement = element.findElement(By.xpath(destinationFareButtonXPath));
		
		return subElement;
	}
	
	// Return a node which is parent of Continue button
	// There are multiple buttons of this type so we need a point to search from to find the right one
	public WebElement getContinueButtonRoot  ()
	{
		WebElement element = super.driver.findElement(By.xpath(continueButtonRootXPath));
		
		return element;
	}
	
	// Return Continue button for next page
	// Takes a WebElement which is the parent for this button
	public WebElement getContinueButton (WebElement parentElement)
	{
		WebElement element = parentElement.findElement(By.xpath(continueButtonXPath));
		
		return element;
	}
}
