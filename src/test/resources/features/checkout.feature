Feature: Checkout

  Background: User already login
    Given User already in login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    When User click login button
    Then User is on Home Page

  Scenario: Checkout two items from cart
    Given User add products to cart
    When User click cart button
    And User scrolls to element with "CHECKOUT" on cart page
    And User click on checkout button
    And User fills checkout information with first name "Taylor", last name "Swift", and zip postal "1989"
    And User Click continue button
    And User scrolls to element with text "FINISH" on Checkout Overview Page
    And User click finish button
    Then User successfully checkout product