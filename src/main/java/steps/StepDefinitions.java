package steps;

import java.io.IOException;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.LeanFTHelper;
import utils.LogHelper;
import utils.PropertiesManager;

import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import org.junit.Assert;

import java.net.URI;

public class StepDefinitions{
	
public static Browser browser;
	
	static
	{
		try {
			//Initialize Test Settings
			PropertiesManager.initializeProperties();
			
			//Inititalize LeanFT SDK
			LeanFTHelper.initializeSDK();
			
			
		} catch (Exception e) {			
			e.printStackTrace();
			org.junit.Assert.fail(e.getMessage());
		}
	}
	
	@Before
	public void launchBrowser() throws Exception {
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		config.setServerAddress(new URI("ws://localhost:5095"));
		SDK.init(config);
		Reporter.init();
		//Launch Browser
		browser = LeanFTHelper.launchBrowser();
	}
	
	@After 
	public void closeBrowser() throws GeneralLeanFtException, InterruptedException
	{		
		browser.close();
		Thread.sleep(1000);
	}
	
	@Given("^User is on \"([^\"]*)\" Page$")
	public void user_is_on_Page(String page) throws Throwable {
		
		HomePage HP = new HomePage(browser,LogHelper.logger);
		
		switch(page.toUpperCase())
		{
			case "HOME":					
				browser.navigate(PropertiesManager.getProperty("websiteURL"));
				
				//Check that the Home Page is present
				Assert.assertTrue(HP.checkHomePageExists());
				break;
		}	    
	}

	@When("^User logs in using username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_logs_in_using_username_as_and_password_as(String username, String password) throws Throwable {
		HomePage HP = new HomePage(browser,LogHelper.logger);
		HP.login(username, password);
	}

	@Then("^login should be successful$")
	public void login_should_be_successful() throws Exception {
		HomePage HP = new HomePage(browser,LogHelper.logger);
	    Assert.assertTrue(HP.isLoggedIn());
	}

	@When("^User presses Sign Out button$")
	public void user_presses_Sign_Out_button() throws Throwable {
		HomePage HP = new HomePage(browser,LogHelper.logger);
		HP.logOut();
	}

	@Then("^logout should be successful$")
	public void logout_should_be_successful() throws Throwable {
		HomePage HP = new HomePage(browser,LogHelper.logger);
	    Assert.assertTrue(HP.isLoggedOut());
	}

}
