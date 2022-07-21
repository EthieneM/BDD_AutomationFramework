package TestRunner;

import Core.BaseClass;
import Utilities.Enums;
import Utilities.SeleniumDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources/Features/OrderProducts.feature"},
        publish = true,
        glue = {"StepDef"})

public class LocalRunner extends BaseClass {

  @BeforeClass
  public static void setup() {
    browserType = Enums.BrowserType.Chrome;
    testEnvironment = Enums.Environment.SAUCE;
    seleniumDriverInstance = new SeleniumDriver(browserType);
  }

  @AfterClass
  public static void teardown() {
    Driver.close();
  }
}
