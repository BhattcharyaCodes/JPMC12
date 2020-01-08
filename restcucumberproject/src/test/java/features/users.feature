Feature: This feature is to check /users GET API
  Call /users API to test different retrieval scenarios

  Scenario: Retrieve list of all Users
    Given  users exist in the database
    When I perform GET operation for "/users"
    Then I should receive 200 status code

  Scenario: Retrieve a specific valid User by id
    Given a user exists with a valid id
    When I perform GET operation for "/users"
    And I perform GET operation for userId "1"
    Then I should see the user's name as "Leanne Graham"

