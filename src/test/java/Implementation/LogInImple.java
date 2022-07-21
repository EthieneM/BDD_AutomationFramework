package Implementation;

import Core.BaseClass;
import Core.TestFailedException;
import PageObject.LoginPageObject;

public class LogInImple extends BaseClass {

  public boolean login() throws TestFailedException {

    if (!seleniumDriverInstance.navigateTo(testEnvironment.url)){
      throw new TestFailedException("Failed to navigate to "+testEnvironment.url);
    }

    if (!seleniumDriverInstance.waitForElementByXpath(LoginPageObject.SwagLabsXPageXpath())){
      throw new TestFailedException("Failed to navigate to "+testEnvironment.url);
    }

    takeAScreenShot("Navigated "+testEnvironment.url+" successfully ");

    if (!seleniumDriverInstance.enterTextByXpath(LoginPageObject.userNameXpath(),testEnvironment.username)){
      throw new TestFailedException("Failed to enter user name text ");
    }

    if (!seleniumDriverInstance.enterTextByXpath(LoginPageObject.userPassWordXpath(),testEnvironment.password)){
      throw new TestFailedException("Failed to enter user password text ");
    }

    if (!seleniumDriverInstance.clickElementByXpath(LoginPageObject.loginButtonXpath())){
      throw new TestFailedException("Failed to click login button ");
    }

    if (!seleniumDriverInstance.waitForElementByXpath(LoginPageObject.productsPageXpath())){
      throw new TestFailedException("Failed to login ");
    }
    takeAScreenShot("Login successfully ");

   return true;
  }
}
