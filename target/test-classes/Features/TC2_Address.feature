@Address
Feature: Address Module API automation

  Scenario Outline: Verify add new address to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for Add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User verify the status code is 200
    And user verify the addUserAddress response message matches 'Address added successfully'

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address        | address_type |
      | Bala       | JI        | 9546826789 | shoba     |    10 |   13 |     103 |  653214 | Kutralam Kovai | Home         |

  Scenario Outline: Verify update address to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for update address "<address_id>","<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User verify the status code is 200
    And user verify the updateUserAddress response message matches 'Address updated successfully'

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address            | address_type |
      | Bala       | JI        | 9546826789 | Prestige  |    10 |   13 |     103 |  653214 | Mettupalayam Kovai | Home         |

  Scenario Outline: Verify delete address to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for delete existing address
    And User send "DELETE" request for deleteUserAddress endpoint
    Then User verify the status code is 200
    And user verify the deleteUserAddress response message matches 'Address deleted successfully'

  Scenario Outline: Verify get all address to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    And User send "GET" request for getUserAddress endpoint
    Then User verify the status code is 200
    And user verify the getUserAddress response message matches 'OK'
