package StepDef;

import Core.BaseClass;
import Core.TestFailedException;
import Core.TestRunner;
import Implementation.LogInImple;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.Assert;



public class Login extends BaseClass {

  private LogInImple logInImple;


  public Login() {
    logInImple = new LogInImple();
  }

  @Before
  public void beforeTest(Scenario scenario) {
    try {
      currentScenario = scenario;
    } catch (Exception ioe) {
      System.err.println("[ERROR] - Failed to read/write scenario count setup file - " + ioe.getMessage());
    }
  }

  public void checkTestResult(TestRunner result) {
    try {
      result.run();
    } catch (TestFailedException e) {
      Assert.fail(e.getMessage());
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }

  @Given("I navigate and login to the SWAGLABS web application")
  public void iNavigateAndLoginToTheSWAGLABSWebApplication(){
    checkTestResult(() ->
    {
      logInImple.login();
    });
  }
}
