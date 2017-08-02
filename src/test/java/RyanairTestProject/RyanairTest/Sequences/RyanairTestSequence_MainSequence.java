package RyanairTestProject.RyanairTest.Sequences;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import RyanairTestProject.RyanairTest.pageObjects.RyanairPageObject_FlightSelect;
import RyanairTestProject.Tests.RyanairTestObject_FlightSelect;
import RyanairTestProject.Tests.RyanairTestObject_HomePage;
import RyanairTestProject.Tests.RyanairTestObject_SeatSelect;

//////////////////////////////////////////////////////////////
//
//		Ryanair Main Test Sequence Object
//
//		Ties test methods together in correct sequence for performing a given test case
//		Creates drivers for interacting with browser
//		Creates test objects for each page and uses them to interact with webpages
//
//////////////////////////////////////////////////////////////

public class RyanairTestSequence_MainSequence extends RyanairTestSequence_Base {

	private WebDriver driver;
	private RyanairTestObject_HomePage ryanairHomeTest;
	private RyanairTestObject_FlightSelect ryanairFlightTest;
	private RyanairTestObject_SeatSelect ryanairSeatTest;
	
	private int numberOfAdults = 0;
	private int numberOfTeens = 0;
	private int numberOfChildren = 0;
	private int numberOfInfants = 0;
	
	// Before running test, setup Firefox driver and open browser
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	// After running test, kill the driver and close the browser
	@After
	public void tearDown()
	{
		// Add a wait before closing to see results of testing
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Test
	public void mainSequence()
	{
		// Perform testing on the Ryanair Home Page
		// Create a Test Object to handle the home page
		ryanairHomeTest = new RyanairTestObject_HomePage(driver);
		
		// Create the page object
		ryanairHomeTest.createPageObject();
		
		// Input departure and destination airports
		ryanairHomeTest.inputDepartureAirport("Dublin");
		ryanairHomeTest.inputDestinationAirport("London Gatwick");
		
		// Input travel dates
		ryanairHomeTest.inputDepartureDate("01/09/2017");
		ryanairHomeTest.inputReturnDate("08/09/2017");
		
		// Setup number of passengers of each category
		numberOfAdults = 2;
		numberOfTeens = 0;
		numberOfChildren = 1;
		numberOfInfants = 0;
		
		// Add passengers for each category
		ryanairHomeTest.addPassengers(numberOfAdults,numberOfTeens, numberOfChildren, numberOfInfants);
		
		// Perform the flight search
		ryanairHomeTest.searchFlights();
		
		// Close any popups that appear
		ryanairHomeTest.closePopUps();
		
		// Wait for next page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Create Test Object for Ryanair Flight search pahe
		ryanairFlightTest = new RyanairTestObject_FlightSelect(driver);
		
		// Create the pahe object
		ryanairFlightTest.createPageObject();
		
		// Check origin and destination are correct
		// TODO: Fix this check
		//ryanairFlightTest.checkOriginandDestination("Dublin", "London Gatwick");
		
		// Select the correct flights
		ryanairFlightTest.selectFlights();
		
		// Wait for next page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Create Test Object for Seat Selection page
		ryanairSeatTest = new RyanairTestObject_SeatSelect(driver);
		
		// Create the page object
		ryanairSeatTest.createPageObject();
		
		// Close any popups that appear
		ryanairSeatTest.closePopUp();
		
		// Select seats for all passengers
		ryanairSeatTest.selectAvailableSeats((numberOfAdults+numberOfTeens+numberOfChildren+numberOfInfants));
		
	}
	
}
