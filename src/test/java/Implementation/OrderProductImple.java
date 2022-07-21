package Implementation;

import Core.BaseClass;
import Core.TestFailedException;
import PageObject.LoginPageObject;
import PageObject.OrderProductPageObjects;
import org.openqa.selenium.By;

public class OrderProductImple extends BaseClass {

  public boolean addProductToCart(String name) throws TestFailedException {


    if (!seleniumDriverInstance.scrollToElementByXpath(OrderProductPageObjects.addProductToCartXpath(name))) {
      throw new TestFailedException("Failed to scroll ADD TO CART button for product : " + name);
    }

    if (!seleniumDriverInstance.clickElementByXpath(OrderProductPageObjects.addProductToCartXpath(name))) {
      throw new TestFailedException("Failed to click ADD TO CART button for product : " + name);
    }

    totalProduct++;
    double price = Double.parseDouble( Driver.findElement(By.xpath(OrderProductPageObjects.productPriceXpath(name))).getText().substring(1));
    totalProductPrice = totalProductPrice + price;
    if (!seleniumDriverInstance.scrollToElementByXpath(OrderProductPageObjects.totalProductAddedTOCartXpath(totalProduct))) {
      throw new TestFailedException("Failed to scroll to cart");
    }

    if (!seleniumDriverInstance.waitForElementByXpath(OrderProductPageObjects.totalProductAddedTOCartXpath(totalProduct))) {
      throw new TestFailedException("Failed to click add product " + name + " to cart");
    }

    takeAScreenShot("Added " + name + " to cart successfully ");

    return true;
  }

  public boolean validateAddedProductOnTheCart(String name) throws TestFailedException {

    if (!seleniumDriverInstance.scrollToElementByXpath(OrderProductPageObjects.totalProductAddedTOCartXpath(totalProduct))) {
      throw new TestFailedException("Failed to scroll to cart");
    }

    if (!seleniumDriverInstance.clickElementByXpath(OrderProductPageObjects.totalProductAddedTOCartXpath(totalProduct))) {
      throw new TestFailedException("Failed to click add product " + name + " to cart");
    }
    if (!seleniumDriverInstance.waitForElementByXpath(OrderProductPageObjects.yourCartPageXpath())) {
      throw new TestFailedException("Failed to navigate to YOUR CART page");
    }

    if (!seleniumDriverInstance.waitForElementByXpath(OrderProductPageObjects.productOnTheCartXpath(name))) {
      throw new TestFailedException("Failed to add product " + name + " on YOUR CART ");
    }

    takeAScreenShot("Product " + name + " was added on YOUR CART successfully");

    if (!seleniumDriverInstance.clickElementByXpath(OrderProductPageObjects.continueShoppingXpath())) {
      throw new TestFailedException("Failed to click continue shopping button ");
    }

    return true;
  }

  public boolean checkOut(String name, String surname, String code) throws TestFailedException {

    if (!seleniumDriverInstance.clickElementByXpath(OrderProductPageObjects.totalProductAddedTOCartXpath(totalProduct))) {
      throw new TestFailedException("Failed to click add product " + name + " to cart");
    }
    if (!seleniumDriverInstance.waitForElementByXpath(OrderProductPageObjects.yourCartPageXpath())) {
      throw new TestFailedException("Failed to navigate to YOUR CART page");
    }

    if (!seleniumDriverInstance.clickElementByXpath(OrderProductPageObjects.checkOutButtonXpath())) {
      throw new TestFailedException("Failed to failed to click checkout button");
    }

    if (!seleniumDriverInstance.waitForElementByXpath(OrderProductPageObjects.checkOutYourInfoPageXpath())) {
      throw new TestFailedException("Failed to navigate to Checkout: Your Information page");
    }

    if (!seleniumDriverInstance.enterTextByXpath(OrderProductPageObjects.nameInputXpath(), name)) {
      throw new TestFailedException("Failed to enter name");
    }
    if (!seleniumDriverInstance.enterTextByXpath(OrderProductPageObjects.surnameInputXpath(), surname)) {
      throw new TestFailedException("Failed to enter surname");
    }

    if (!seleniumDriverInstance.enterTextByXpath(OrderProductPageObjects.postalCodeXpath(), code)) {
      throw new TestFailedException("Failed to enter name");
    }

    takeAScreenShot("Successfully navigated to Checkout: Your Information page and capture details");

    if (!seleniumDriverInstance.clickElementByXpath(OrderProductPageObjects.continueButtonXpath())) {
      throw new TestFailedException("Failed to failed to click Continue Button");
    }

    return true;
  }
  public boolean checkOutOverView() throws TestFailedException {


    if (!seleniumDriverInstance.waitForElementByXpath(OrderProductPageObjects.checkOutOverViewXpath())) {
      throw new TestFailedException("Failed to navigate to Checkout: Overview page");
    }
    if (!seleniumDriverInstance.scrollToElementByXpath(OrderProductPageObjects.totalXpath())) {
      throw new TestFailedException("Failed to scroll to total ");
    }
    String srtPrice = Driver.findElement(By.xpath(OrderProductPageObjects.totalXpath())).getText().split(":")[1];
    double total = Double.parseDouble(srtPrice.trim().substring(1));
    if(total != totalProductPrice){
      throw new TestFailedException("Failed to expected value is "+totalProductPrice+" actual value :"+total);
    }
    takeAScreenShot("Expected value :"+totalProductPrice+" matched with actual value "+total);

    if (!seleniumDriverInstance.clickElementByXpath(OrderProductPageObjects.finishButtonXpath())) {
      throw new TestFailedException("Failed to click finish button");
    }
    if (!seleniumDriverInstance.scrollToElementByXpath(OrderProductPageObjects.checkOutCompletePageXpath())) {
      throw new TestFailedException("Failed to navigate to Checkout: Complete! page");
    }

    if (!seleniumDriverInstance.waitForElementByXpath(OrderProductPageObjects.checkOutCompletePageXpath())) {
      throw new TestFailedException("Failed to navigate to Checkout: Complete! page");
    }

    if (!seleniumDriverInstance.waitForElementByXpath(OrderProductPageObjects.THANKYOUFORYOURORDERXpath())) {
      throw new TestFailedException("Failed to complete your order");
    }

    takeAScreenShot("Successfully order your items");

    return true;
  }

}
