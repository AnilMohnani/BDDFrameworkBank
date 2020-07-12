package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;

public class MyHomeBankPage {
	WebDriver driver;

	public MyHomeBankPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[contains(text(),'Welcome')]")
	public WebElement welcomeText;
	
	public String getWelcomeText()
	{
		String text=BrowserActions.getText(welcomeText);
		return text;
	}
			

}
