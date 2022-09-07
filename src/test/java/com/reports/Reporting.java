package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJVMReport(String jsonFile) {
		

		File file = new File("C:\\Users\\MITHRA\\eclipse-workspace\\OMRBranchAPIAutomation\\target");

	Configuration config = new Configuration(file, "Api testing");

	config.addClassifications("Browser", "chrome");
	config.addClassifications("Browser verison", "105");
	config.addClassifications("os", "win 10");
	config.addClassifications("sprint", "34");


	List<String> jsonfiles = new ArrayList<String>();
	jsonfiles.add(jsonFile);

	ReportBuilder builder = new ReportBuilder(jsonfiles, config);

	builder.generateReports();
	}

}
