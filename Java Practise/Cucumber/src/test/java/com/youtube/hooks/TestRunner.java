package com.youtube.hooks;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/youtube hooks", glue = {
		"com.youtube.hooks","hooks" }, dryRun = false, monochrome = true)
public class TestRunner {

}
