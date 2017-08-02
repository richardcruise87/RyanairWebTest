package RyanairTestProject.RyanairTest.pageObjects;

import org.openqa.selenium.WebDriver;

//////////////////////////////////////////////////////////////
//
//		Base Class for Ryanair Page Objects
//		
//		All Page Object Classes will extend this class
//		Put common methods & variables in here
//
//////////////////////////////////////////////////////////////

public class RyanairPageObject_Base {

	protected WebDriver driver;
	protected String baseURL;
	protected String pageTitle;
	
	
	// Common constructor to assign web driver object
	public RyanairPageObject_Base(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	// Method to return page title
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
}
