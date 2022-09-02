package stepDefinitions;



import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import utils.WebUtils;


public class CheckLogin extends WebUtils {
	loginPage obj;
	
	@Given("User Launch Browser")
	public void user_launch_browser() {
		System.out.println("Browser Launched");
		
	}

	@And("User Opens {string}")
	public void user_opens(String url) {
		System.out.println("Navigating to the given Url");
		driver.get(url);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		obj= new loginPage(driver);
		obj.email.clear();
		obj.email.sendKeys(email);
		obj.password.clear();
		obj.password.sendKeys(password);
	}

	@And("User Clicks Login")
	public void user_clicks_login() {
		obj.loginBtn.click();
	}

	@Then("Page Title Should be {string}")
	public void page_title_should_be(String expectedTitle) throws Exception {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Page Title Verified");
			System.out.println("Login Successful");
		}
		else {
			System.out.println("Invalid Page");
			throw new Exception("Login was unsuccessfull");
		}
	}

	@Then("User Click Logout")
	public void user_click_logout() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@And("Close Browser")
	public void close_browser() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
