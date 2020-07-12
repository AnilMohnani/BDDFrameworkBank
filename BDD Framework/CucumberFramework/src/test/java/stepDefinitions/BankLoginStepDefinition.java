package stepDefinitions;

import org.junit.Assert;

import com.cucumberFramework.pageObjects.BankLoginPage;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BankLoginStepDefinition extends TestBase {
	BankLoginPage lp;
	MyHomeBankPage hbp;
	
	@Given("User is on Bank Login Screen")
	public void user_is_on_bank_login_screen() {
		lp=new BankLoginPage(driver);
	}

	@When("User Enters Valid {string} and Valid {string}")
	public void user_enters_valid_and_valid(String username, String password) {
		lp.enterUsername(username);
		lp.enterPassword(password);
		
	}
	
	@And("User Clicks Sign In Button")
	public void user_clicks_sign_in_button() {
		hbp=lp.signInButtonClick();
	}

	@Then("User Should land on Account Home Screen with {string} Message")
	public void user_should_see_message_on_account_home_screen(String textMessage) {
		
		String actualMessage=hbp.getWelcomeText();
	  Assert.assertEquals(textMessage, actualMessage);
	}
	
	@When("User Enters valid {string} and Invalid {string}")
	public void user_enters_valid_and_invalid(String validUsername, String invalidPassword) {
		lp.enterUsername(validUsername);
		lp.enterPassword(invalidPassword);
		
	}
	@Then("User should see {string} Message on the login screen")
	public void user_should_see_message_on_the_login_screen(String expectedLoginMessage) {
		String actualLoginErrorMessage=lp.getLoginErrorMessage();
		Assert.assertEquals(expectedLoginMessage, actualLoginErrorMessage);
	}

	
}
