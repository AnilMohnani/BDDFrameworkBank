package com.cucumberFramework.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public Properties prop;
	FileInputStream fis;
	String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\cucumberFramework\\resources\\globalProperties.properties";

	public WebDriver browserInitialisation() throws IOException {
		try {
			fis = new FileInputStream(path);
			//System.out.println(path);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);
		if (browserName.equals("chrome")) {
		try {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} catch(Exception e)
		{
			System.out.println("Chrome is not working as expected.Please start again");
			System.out.println(e.getMessage());
		}}
		else {
			if (browserName.equals("firefox")) {
		}
			try {
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"console");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			} catch(Exception e)
			{
				System.out.println("Chrome is not working as expected.Please start again");
				System.out.println(e.getMessage());
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
}
