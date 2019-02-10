package suiteSetUpAndTearDown;

import java.util.concurrent.TimeUnit;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import utils.ConfigurationReader;
import utils.DBUtils;
import utils.Driver;

public class SuiteSetUp {
	DBUtils db = new DBUtils();
    @Before
    public void suiteSetup(Scenario scenario) {
        Reporter.assignAuthor("Cybertek Alpha");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Integer.valueOf(ConfigurationReader.getProperty("seleniumtimeout")),TimeUnit.SECONDS);
        System.out.println();
        System.out.println("...........START AUTOMATION.............");
        System.out.println();
    }
    @Before("@dbsetup")
    public void suiteSetupDB() {
        db.startDBConnection();
        Reporter.assignAuthor("Cybertek Alpha");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Integer.valueOf(ConfigurationReader.getProperty("timeout")),TimeUnit.SECONDS);
        System.out.println();
        System.out.println("...........START AUTOMATION.............");
        System.out.println();
    }
}
