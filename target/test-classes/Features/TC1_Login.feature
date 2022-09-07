@Login
Feature: Login Module API automation

  Scenario Outline: Get usr logtoken from login endpoint
    Given User add header
    And User add basic authentication for login
    When User send "POST" request for login endpoint
    Then User verify the status code is 200
    And user verify the login response body firstName present as "Balaji" and get the log token saved
