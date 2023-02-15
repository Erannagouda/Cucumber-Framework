
Feature: Actitime login with parameters
  Scenario Outline: valid and invalid login credentials
    Given user launches browser and enters URL of actitime
    When enters <username> and <password>
    And hits on login button
    Then Actitime home page with <status> is displayed
    Examples: 
      | username  | password |status   |
      | admin |     manager | success |
      | trainee |     trainee | success    |
      |abc|bcd|fail|
