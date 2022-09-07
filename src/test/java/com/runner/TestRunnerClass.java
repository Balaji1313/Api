package com.runner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, features = "src\\test\\resources\\Features", snippets = SnippetType.CAMELCASE, monochrome = true, glue = "com.stepdefinition", stepNotifications = true, plugin = {
		"pretty", "json:target\\Output.json" })
public class TestRunnerClass  {

	 @AfterClass
	 public static void afterclass() {
	
	 Reporting.generateJVMReport("C:\\Users\\MITHRA\\eclipse-workspace\\OMRBranchAdactinAutomation\\target\\Output.json");
	
	 }

}

// @Login
// @Address
// @Changeprofilepic
