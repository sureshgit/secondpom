package com.hubspot.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	Properties getconfigProp;
	
	WebDriver driver ;
	
	public WebDriver init_driver(String browserName)
	{
		System.out.println("browser name is " + browserName);
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
			if(browserName.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else 
				if(browserName.equals("safari"))
				{
					WebDriverManager.getInstance(SafariDriver.class).setup();
					driver=new SafariDriver();
				}
				else
				{
					System.out.println("browser name " + browserName +" no such browser found ");
				}
		
		
		
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(30 ,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				//driver.get(url);
				
				return driver ;	
	
	}
	
	public Properties init_properties() 
	{
		getconfigProp=new Properties();
		
		String path=".//src\\main\\java\\com\\huspot\\config\\config.properties";  //if file missing/someone changing for handling we given try and catch
		
		try {
			FileInputStream file=new FileInputStream(path);  //by fileinput connection has been done with config and with this one 
			getconfigProp.load(file); //file have all properties like where we created config.properties file 
			}
		
		catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("some issue with config properties ..please config correct configf"); //when user this msg immediatly come to know that some problem with config properties and all
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return getconfigProp; ///this will return all properties 
		
	}

}
