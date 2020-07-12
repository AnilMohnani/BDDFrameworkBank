package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase {
	WebDriver driver;

	@Before
	public void setUp() {
		try {
			driver = browserInitialisation();
			driver.get(prop.getProperty("bankUrl"));
		} catch (IOException e) {
			System.out.println("Website Not Working.Please try later");
			System.out.println(e.getMessage());
		}

	}

	@After
	public void tearDown(Scenario scenario) {
		TakesScreenshot ts;
		if (scenario.isFailed()) {
			ts = (TakesScreenshot) TestBase.driver;
			final byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			// scenario.embed(screenshot,"image/png");
			scenario.attach(screenshot, "image/png", scenario.getName());
		} else {

			ts = (TakesScreenshot) TestBase.driver;
			final byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			// scenario.embed(screenshot,"image/png");
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		driver.close();
	}
}
