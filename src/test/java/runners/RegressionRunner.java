package runners;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import utils.FileReaderManager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin={"pretty:target/cucumber-pretty.txt",
				"html:target/html-report",
				"json:target/json/json-report.json",
				"junit:target/junit/junit-report.xml",
				"usage:target/cucumber-usage.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports-Regression/Regression_Report.html"
			},
		tags = {"@ROAR_21", "~@ignore",},   
        features= {"src/test/resources/features"},
        glue= {"com/cybertek/common/step_definitions","com/cybertek/light/step_definitions","com/cybertek/dark/step_definitions","com/cybertek/chicago/step_definitions","com/cybertek/suitesetupandteardown"},
        dryRun=false,
        monochrome = true
		)
public class RegressionRunner {
public class CukesRunner{
		
	//this is separate report other than default one
		@AfterClass
		public void writeExtentReport() {
			Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		}

	}
}

