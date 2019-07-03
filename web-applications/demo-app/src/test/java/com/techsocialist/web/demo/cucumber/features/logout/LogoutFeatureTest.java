package com.techsocialist.web.demo.cucumber.features.logout;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/logout", glue = "com.techsocialist.web.demo.features.logout.stepdefs")
public class LogoutFeatureTest {

}
