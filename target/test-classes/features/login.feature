#Author: amresh.kr.bb@gmail.com
#Feature: Demo of Login functionality.
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given The user is on the login page
    When The user enters valid credentials
    Then The user should be navigated to the home page

  Scenario: Login with invalid credentials
    Given The user is on the login page
    When The user enters invalid credentials
    Then An error message should be displayed

  Scenario: Login with empty username
    Given The user is on the login page
    When The user leaves the username field empty
    And The user enters a valid password
    Then An error message should be displayed
