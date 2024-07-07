Feature: Login

  @positive-test
  Scenario: User successfully login using valid username and password
    Given User already in login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    When User click login button
    Then User is on Home Page

  @negative-test
  Scenario: Login using valid username and invalid password
    Given User already in login page
    And User input username with "standard_user"
    And User input password with "wrong_password"
    When User click login button
    Then User get Error message
    And user stay in login page