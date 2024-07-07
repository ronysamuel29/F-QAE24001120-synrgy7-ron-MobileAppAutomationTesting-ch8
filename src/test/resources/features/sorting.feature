Feature: Sorting

  Background: User already login
    Given User already in login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    When User click login button
    Then User is on Home Page

  Scenario: Sorting items low to high
    Given User click sorting items button
    When User choose low to high button
    Then Items on home page will be sorted from low to high