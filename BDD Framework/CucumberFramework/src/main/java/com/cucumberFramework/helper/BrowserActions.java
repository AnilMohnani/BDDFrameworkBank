package com.cucumberFramework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserActions {

	WebDriver driver;

	public static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Element not found");
			System.out.println(e.getMessage());

		}
	}

	public static void sendKeysData(WebElement element, String data) {
		try {
			element.sendKeys(data);

		} catch (Exception e) {
			System.out.println("There is some problem in finding the element");
			System.out.println(e.getMessage());
		}
	}

	public static String getText(WebElement element) {
		String text = null;
		try {
			text = element.getText();
		} catch (Exception e) {
			System.out.println("Text not found");
			System.out.println(e.getMessage());
		}
		return text;
	}
	public static void selectByIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	
}
