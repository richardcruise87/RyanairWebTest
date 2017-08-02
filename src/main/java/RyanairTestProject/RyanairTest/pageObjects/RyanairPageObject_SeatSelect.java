package RyanairTestProject.RyanairTest.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//////////////////////////////////////////////////////////////
//
//	Ryanair Seat Selection Page Object Class
//
//	Page Object Class for all Ryanair Seat Selection WebElements
//	Contains methods to return WebElements used by Test cases
//
//////////////////////////////////////////////////////////////

public class RyanairPageObject_SeatSelect extends RyanairPageObject_Base {

	// String variables to store search criteria for Web Elements
	private String popUpWindowXPath = ".//*[@id='ngdialog3']/div/div[2]/div/button";
	private String seatSelectionRootId = "scrollable";
	private String availalbeSeatXPath = "//span[contains(@class, 'seat-row-seat onsale')]";
	
	private String continueButtonRootId = "ngdialog2";
	private String continueButtonRootXPath = "//div[contains(@class, 'dialog-footer')]";
	private String continueButtonXPath = "//button[contains(@class, 'core-btn-primary next')]";
	
	private String differentSeatButtonRootXPath = "//div[contains(@id, 'seat-map-prompt-content')]";
	private String differentSeatButtonRootId = "dialog-body-slot";
	private String differentSeatButtonXPath = "//button[contains(@translate, 'trips.seats.same_seats_no')]";
	
	private String nextButtonRootXPath = "//div[contains(@class, 'dialog-footer')]";
	private String nextButtonXPath = "//button[contains(@class, 'core-btn-primary next')]";
	
	// Standard constructor
	// Don't need to navigate to page as test case will handle that for us
	public RyanairPageObject_SeatSelect(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Popups sometimes appear when opening this page
	// Return the close button for this popup
	public WebElement getPopUpButtonElement ()
	{
		WebElement element = super.driver.findElement(By.xpath(popUpWindowXPath));
		
		return element;
	}
	
	// Return an element that is parent of seat selection menu
	// This ensures we are using the correct menu later
	public WebElement getSeatSelectionRootElement ()
	{
		WebElement element = super.driver.findElement(By.id(seatSelectionRootId));
		
		return element;
	}
	
	// Return a list of all available seats
	// At the moment just looks for ON SALE seat types
	// TODO: Add ability to select other seat types
	public ArrayList<WebElement> getAvailableSeatElements(WebElement parentElement)
	{
		ArrayList<WebElement> elements = new ArrayList<WebElement>();
		
		elements = (ArrayList<WebElement>) parentElement.findElements(By.xpath(availalbeSeatXPath));
		
		return elements;
	}

	// There are several Continue buttons on the page
	// Return a parent node which we can search from
	public WebElement getContinueButtonRootElement ()
	{
		WebElement element = super.driver.findElement(By.xpath(continueButtonRootXPath));
		
		return element;
	}
	
	// Return the continue button element
	// Requires a Web Element object which is the parent of that button
	public WebElement getContinueButtonElement (WebElement parentElement)
	{
		WebElement element = parentElement.findElement(By.xpath(continueButtonXPath));
		return element;
	}

	// Sometimes popup menu appears to offer same seats for return journey
	// Return parent element of popup so it can be dismissed
	public WebElement getDifferentSeatRootElement ()
	{
		WebElement element = super.driver.findElement(By.id(differentSeatButtonRootId));
		
		return element;
	}
	
	// Return all buttons to dismiss popups
	// There may be more than one so return a list
	public ArrayList<WebElement> getDifferentSeatElements(WebElement parentElement)
	{
		ArrayList<WebElement> elements = new ArrayList<WebElement>();
		
		elements = (ArrayList<WebElement>) parentElement.findElements(By.xpath(differentSeatButtonXPath));
		
		return elements;
	}
	
	// There are several Continue buttons on the page
	// Return a parent node which we can search from
	public WebElement getNextButtonRootRootElement ()
	{
		WebElement element = super.driver.findElement(By.xpath(nextButtonRootXPath));
		
		return element;
	}
	
	// Return the continue button element
	// Requires a Web Element object which is the parent of that button
	public WebElement getNextButtonElement (WebElement parentElement)
	{
		WebElement element = parentElement.findElement(By.xpath(nextButtonXPath));
		return element;
	}
}
