package com.fb.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FbFeature",glue = {"com.fb.stepDefinition"})
public class FbTestRunner {

}
