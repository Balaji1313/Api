@Changeprofilepic
Feature: Address Module API automation

  Scenario Outline: Verify add new address to the application through api
    Given User add headers and bearer authorization for accessing upload profile picture endpoints
    When User add form data for adding profile picture
    And User send "POST" request for change profile pic endpoint
    Then User verify the status code is 200
    And user verify the change profile picture response message matches 'Profile updated Successfully'
