Feature: Add 2 products to your shopping cart and checkout

  Background: Open broswer and navivage to the web application
    Given I navigate and login to the SWAGLABS web application

  Scenario: Add 2 products to your shopping cart and checkout
    When I add product "Sauce Labs Backpack" to the cart and validate the cart
    And I add product "Sauce Labs Onesie" to the cart and validate the cart
    Then I use "Ethiene" "Mashishi" postal code "0152" to check out