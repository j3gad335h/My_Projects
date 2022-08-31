package com.youtube.hooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioClass {
	
	

	@Given("broswer is in facebook Page")
	public void broswer_is_in_facebook_page() {
		System.out.println("Borwser is in facebook page");
		
	}

	@When("user enters email and password")
	public void user_enters_email_and_password() {
		System.out.println("user enters email and password");
	}

	@And("user click login button")
	public void user_click_login_button() {
		System.out.println("user clicks login button");
	}

	@Then("user navigated to home page")
	public void user_navigated_to_home_page() {
		System.out.println("User Navigated to the HomePage");
	}
}
