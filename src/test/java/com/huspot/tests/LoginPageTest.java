package com.huspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.Base.BasePage;
import com.pageLayer.LogInPage;

public class LoginPageTest { // these are the testNG classes where written in inside of com.hubspot.test

	BasePage basPage;
	Properties pro;
	WebDriver driver;
	LogInPage page;
	
	
	@BeforeMethod
	public void setup()
	{
		basPage=new BasePage();
		pro=basPage.init_properties();
		String browserName=pro.getProperty("browser");
		
		driver=basPage.init_driver(browserName);
		driver.get(pro.getProperty("url"));
		page=new LogInPage(driver);
	
	}
    
	
	
	@Test(priority=1)	
	public void verifyingLoginPageTitle() throws InterruptedException
	{	Thread.sleep(5000);
		String title=page.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	
	}
	
	
	@Test(priority=2)
	public void verifyingSignUpLinkTest()
	{
		Assert.assertTrue(page.checkSignUpLink());
		
		
	}
	
	
	@Test(priority=3)
	public void logIntest()
	{
		page.doLogin(pro.getProperty("username"),pro.getProperty("password"));
	}
	
	@Test(priority=4)
	public void checkPravacyLinkTest()
	{
		
		Assert.assertTrue(page.checkPravacyLink());
	}
	
	
	/**
	@Test(priority=5)
	public void checkingShowPwdTest()
	{
		Assert.assertTrue(page.checkShowPwd());
	}
	**/
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
}
