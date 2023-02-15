
Feature: Login

  Scenario: Actitime login with valid credentials
    Given user launches browser and enters Actitime URL
    When user enters valid username and password
    And click on login button
    Then Actitime homepage should be displayed
   
  