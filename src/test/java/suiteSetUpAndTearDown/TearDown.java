package suiteSetUpAndTearDown;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import utils.DBUtils;
import utils.Driver;

public class TearDown {
	DBUtils db = new DBUtils();

	@After
	public void suiteTearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
				byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
				scenario.embed(image, "image/png");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException found");
		}
		Driver.closeDriver();
		System.out.println();
		System.out.println("...........END AUTOMATION.............");
		System.out.println();
	}

	@After("@dbteardown")
	public void tearDownDB(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
				byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
				scenario.embed(image, "image/png");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException found");
		}
		Driver.closeDriver();
		db.stopDBConnection();
		System.out.println();
		System.out.println("...........END AUTOMATION.............");
		System.out.println();
	}

}
