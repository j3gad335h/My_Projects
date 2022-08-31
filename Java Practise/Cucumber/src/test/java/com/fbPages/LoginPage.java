package com.fbPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fb.stepDefinition.ReusableMethods;

public class LoginPage extends ReusableMethods {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement emailId;

	@FindBy(id = "pass")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginBtn;

	// Creating Getter and Setter

	public WebElement getEmailId() {
		return emailId;
	}

	public void setEmailId(WebElement emailId) {
		this.emailId = emailId;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

}
