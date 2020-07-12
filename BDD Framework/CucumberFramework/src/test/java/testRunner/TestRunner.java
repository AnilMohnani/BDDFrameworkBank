package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Automation\\Cucumber\\BDD Framework\\BDD Framework\\CucumberFramework\\src\\test\\java\\features", glue = "stepDefinitions", plugin = {
		"pretty", "html:Reports/report.html" }, monochrome = true)
public class TestRunner {

}
