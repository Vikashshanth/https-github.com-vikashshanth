package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.hp.lft.report.*;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.SDKConfigurationFactory;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;

public class LeanFTHelper {
	
	public static void initializeSDK() throws Exception
	{
		ModifiableSDKConfiguration config;
		config =  SDKConfigurationFactory.loadConfigurationFromExternalPropertiesFile("src\\main\\resources\\leanft.properties");
	    SDK.init(config);		   
	    Reporter.init();
	    
	    LogHelper.logger.info("SDK Initialized");
	}
	
	public static Browser launchBrowser() throws GeneralLeanFtException, IOException
	{
		Browser browser;
		BrowserType bType;
		
		FileInputStream iStr = new FileInputStream("src\\main\\resources\\leanft.properties");
	    Properties prop = new Properties();
	    prop.load(iStr);
	    
	    switch(prop.getProperty("BrowserType"))
	    {
	    	case "INTERNET_EXPLORER":
	    		bType = BrowserType.INTERNET_EXPLORER;
	    		break;
	    	case "FIREFOX":
	    		bType = BrowserType.FIREFOX;
	    		break;
	    	case "CHROME":
	    		bType= BrowserType.CHROME;
	    		break;
	    	default:
	    		bType = BrowserType.FIREFOX;
	    }
		
	    browser = BrowserFactory.launch(bType);
	    LogHelper.logger.info("Browser Launched");
		
		return browser;
	}
}
