package com.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.Base.BasePage;

public class LogInPage extends BasePage {
	
	WebDriver driver;

	//1:Locators-By
	
	By emailId=By.id("username");
	By password=By.id("password");
	By login=By.id("loginBtn");
	By signupChecking=By.linkText("Sign up");
	By privacylink=By.linkText("Privacy Policy");
	//By showpwd=By.linkText("Show Password");
	
	
	
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Page actions :titles ,headers,etc
	
	public String getPageTitle()
	{
		return driver.getTitle();

	}
	
	
	
	public boolean checkSignUpLink()
	{
		return driver.findElement(signupChecking).isDisplayed();
	}
	
	
	public HomePage doLogin(String username,String pwd)
	{
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		driver.findElement(privacylink).click();
	//	driver.findElement(showpwd).click();
		
		return new HomePage();
	}
	
	
	public boolean checkPravacyLink()
	{
		return driver.findElement(privacylink).isDisplayed();
		
		
	}
	
	/**
	public boolean checkShowPwd()
	{
		return driver.findElement(showpwd).isDisplayed();
	}
	**/
	
}
