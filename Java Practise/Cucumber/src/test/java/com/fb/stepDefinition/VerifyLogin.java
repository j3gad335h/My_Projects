package com.fb.stepDefinition;


import com.fbPages.LoginPage;
import io.cucumber.java.en.*;

public class VerifyLogin extends ReusableMethods {
	LoginPage obj;
	@Given("broswer is in facebook Page")
	public void broswer_is_in_facebook_page() {
		driver.get("https://www.facebook.com/");
		obj = new LoginPage(driver);	
	}

	@When("user enters email and password")
	public void user_enters_email_and_password() {
		obj.getEmailId().sendKeys("ram123@gmail.com");
		obj.getPassword().sendKeys("Password");
	}

	@And("user click login button")
	public void user_click_login_button() {
		obj.getLoginBtn().click();
	}

	@Then("user navigated to home page")
	public void user_navigated_to_home_page() throws Exception {
		System.out.println("User Navigated to the HomePage");
		String title=driver.getTitle();
		if(!title.contains("Amazon")) {
			throw new Exception("This is not Amazon Website");
		}
		
	}
}
