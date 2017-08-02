package RyanairTestProject.RyanairTest.pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//////////////////////////////////////////////////////////////
//
//		Ryanair Home Page Object Class
//
//		Page Object Class for all Ryanair Homepage WebElements
//		Contains methods to return WebElements used by Test cases
//
//////////////////////////////////////////////////////////////

public class RyanairPageObject_HomePage extends RyanairPageObject_Base {
	
	// Constructor will asign web driver and navigte to Base URL since this is first page we interact with
	public RyanairPageObject_HomePage(WebDriver driver) {
		super(driver);
		this.baseURL = "http://www.ryanair.com/ie/en";
		this.pageTitle = "Official Ryanair website | Cheap flights from Ireland | Ryanair";
		
		driver.get(baseURL);
		
        System.out.println(driver.getTitle());

        // Check to ensure the page title is correct, otherwise throw an exception
        if (!driver.getTitle().equals(this.pageTitle)){
            throw new RyanairTestProject.RyanairTest.exceptions.WrongPageException("Incorrect page for Ryanair Home page");
        }
	}
	
	// Return text box for Departure Airport
	public WebElement getDepartureAirportElement()
	{
		//WebElement departureAirport = super.driver.findElement(By.name("departureAirportName"));
		WebElement departureAirport = super.driver.findElement(By.xpath(".//*[@id='search-container']/div[1]/div/form/div[2]/div/div/div[1]/div[2]/div[2]/div/div[1]/input"));
		
		return departureAirport;
	}

	// Return dropdown menu element for departure airport
	// Need to click this for webpage to respond correctly
	// If vaid airport name has been typed in, the correct airport will be at top of list
	public WebElement getDepartureAirportMenuElement()
	{
		WebElement departureAirportMenu = super.driver.findElement(By.xpath(".//*[@id='search-container']/div[1]/div/form/div[2]/div/div/div[1]/div[3]/div/div/div[2]/popup-content/core-linked-list/div[2]/div[1]/div[3]/span"));
		
		return departureAirportMenu;
	}
	
	// Return text box for Destination Airport
	public WebElement getDestinationAirportElement()
	{
		WebElement element = super.driver.findElement(By.xpath(".//*[@id='search-container']/div[1]/div/form/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/input"));
		
		return element;
	}

	// Return dropdown menu element for destination airport
	// Need to click this for webpage to respond correctly
	// If vaid airport name has been typed in, the correct airport will be at top of list
	public WebElement getDestinationAirportMenuElement()
	{
		WebElement element = super.driver.findElement(By.xpath(".//*[@id='search-container']/div[1]/div/form/div[2]/div[1]/div/div[2]/div[3]/div/div/div[2]/popup-content/core-linked-list/div[2]/div[1]/div[3]/span"));
		
		return element;
	}

	// Return the textbox for setting the departure date
	// Since this is actually 3 text boxes, return an array of WebElement objects
	public WebElement[] getDepartureDateElement()
	{
		WebElement[] elements = new WebElement[3];
		
		elements[0] = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]"));
		elements[1] = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[2]/div[2]/div/input[2]"));
		elements[2] = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]"));
		
		return elements;
	}
	
	// Grab the departure date from the dropdown menu
	// For now just make this static date, will add interactivity later
	public WebElement getDepartureDateMenuElement()
	{
		WebElement element = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[3]/div/div/div[2]/popup-content/core-datepicker/div/div[1]/ul/li[2]/ul[2]/li[8]/span"));
		
		return element;
	}
	
	// Return the textbox for setting the return date
	// Since this is actually 3 text boxes, return an array of WebElement objects
	public WebElement[] getReturnDateElement()
	{
		WebElement[] elements = new WebElement[3];
		
		elements[0] = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[1]/div/div[2]/div/div[2]/div[2]/div/input[1]"));
		elements[1] = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[1]/div/div[2]/div/div[2]/div[2]/div/input[2]"));
		elements[2] = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[1]/div/div[2]/div/div[2]/div[2]/div/input[3]"));
		
		return elements;
	}
	
	// Grab the departure date from the dropdown menu
	// For now just make this static date, will add interactivity later
	public WebElement getReturnDateMenuElement()
	{
		WebElement element = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[1]/div/div[2]/div/div[3]/div/div/div[2]/popup-content/core-datepicker/div/div[1]/ul/li[2]/ul[2]/li[15]/span"));
		
		return element;
	}
	
	// Return dropdown menu element for the passenger menu
	public WebElement getPassengerMenuElement()
	{
		WebElement element = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[2]/div[2]/div[2]/div/div[1]"));
		
		return element;
	}
	
	// Return plus button for adult passengers
	public WebElement getPassengerMenuAdultPlusElement()
	{
		WebElement element = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[3]/core-inc-dec/button[2]"));
		
		return element;
	}

	// Return plus button for child passengers
	public WebElement getPassengerMenuChildrenPlusElement()
	{
		WebElement element = super.driver.findElement(By.xpath(".//*[@id='row-dates-pax']/div[2]/div[3]/div/div/div[2]/popup-content/div[8]/div/div[3]/core-inc-dec/button[2]"));
		
		return element;
	}
	
	// TODO: Add teens & infants
	// TODO: Add minus buttons
	
	// Return the button to perform the flight search
	public WebElement getSearchButton()
	{
		WebElement element = super.driver.findElement(By.xpath(".//*[@id='search-container']/div[1]/div/form/div[4]/button[2]"));
		
		return element;
	}
	
	// Popups sometimes appear when clicking next
	// Grab any close buttons that are available and return as a List object
	public List<WebElement> getPopCloseButtons()
	{
		List<WebElement> elements = new ArrayList<WebElement>();
		
		elements = super.driver.findElements(By.className("promo-popup-close"));
		
		return elements;		
	}
	
}
