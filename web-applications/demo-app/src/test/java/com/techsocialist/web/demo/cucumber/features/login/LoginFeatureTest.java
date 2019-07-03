package com.techsocialist.web.demo.cucumber.features.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/login", glue = "com.techsocialist.web.demo.features.login.stepdefs")
public class LoginFeatureTest {

}