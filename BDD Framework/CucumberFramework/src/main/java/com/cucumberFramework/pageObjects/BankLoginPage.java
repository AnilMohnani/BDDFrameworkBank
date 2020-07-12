package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;
import com.cucumberFramework.helper.WaitHelper;

public class BankLoginPage {

	WebDriver driver;
	WaitHelper waitHelper;
	public BankLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
	}
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(css = "#password")
	public WebElement password;
	
	@FindBy(xpath = "//*[@id='submit']")
	public WebElement signInButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up Here']")
	public WebElement signUpNavigationLink;
	
	@FindBy(xpath="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
	public WebElement loginErrorMessage;
	public void enterUsername(String usernameData)
	{
		BrowserActions.sendKeysData(username, usernameData);
	}
	public void enterPassword(String passwordData)
	{
		BrowserActions.sendKeysData(password, passwordData);
	}
	public MyHomeBankPage signInButtonClick()
	{
		BrowserActions.elementClick(signInButton);
		return new MyHomeBankPage(driver);
		
	}
	public void navigateToSignupPage()
	{
		BrowserActions.elementClick(signUpNavigationLink);
	}
	public String getLoginErrorMessage()
	{
		waitHelper.waitForElement(loginErrorMessage);
		String errorMsg=BrowserActions.getText(loginErrorMessage);
		String finalError=errorMsg.substring(6,48);
		return finalError;
		
	}
	
	
}
