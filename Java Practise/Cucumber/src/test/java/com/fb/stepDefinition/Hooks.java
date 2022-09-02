package com.fb.stepDefinition;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends ReusableMethods {

	@Before
	public void launchBrowser() {
		System.out.println("---Launching the Browser---");
		setupBrowser();
	}
	
	@After
	public void closeBrowser(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			System.out.println("Scenario Failed");
			takeSs();
		}
		System.out.println("---Closing the Browser---");
		
	}
}
