package StepDef;

import Core.BaseClass;
import Core.TestFailedException;
import Core.TestRunner;
import Implementation.OrderProductImple;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class OrderProduct extends BaseClass {

  private OrderProductImple OrderProduct;

  public OrderProduct() {
    OrderProduct = new OrderProductImple();
  }

  @Before
  public void beforeTest(Scenario scenario) {
    try {
      currentScenario = scenario;
    } catch (Exception ioe) {
      System.err.println("[ERROR] - Failed to read/write scenario count setup file - " + ioe.getMessage());
    }
  }

  public void checkTestResult(TestRunner result){
    try {
      result.run();
    } catch (TestFailedException e) {
      Assert.fail(e.getMessage());
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }

  @And("I add product {string} to the cart and validate the cart")
  public void iAddProductToTheCartAndValidateTheCart(String name) {
    checkTestResult(() ->
    {
      OrderProduct.addProductToCart(name);
      OrderProduct.validateAddedProductOnTheCart(name);
    });
  }

  @Then("I use {string} {string} postal code {string} to check out")
  public void iUsePostalCodeToCheckOut(String name, String surname, String code) {
    checkTestResult(() ->
    {
      OrderProduct.checkOut(name,surname,code);
      OrderProduct.checkOutOverView();

    });
  }
}
