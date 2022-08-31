package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Jegadeesh\\eclipse-workspace\\Cucumber\\src\\test\\resources\\GoogleFeature",
glue={"google.stepDefinition"},
dryRun=false)

public class GoogleTestRunner {

}
