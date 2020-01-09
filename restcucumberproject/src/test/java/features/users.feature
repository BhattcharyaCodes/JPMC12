Feature: This feature is to check /users GET API
  Call /users API to test different retrieval scenarios

   Scenario: Retrieve list of all Users
    Given  users exist in the database
    When I perform GET operation for "/users"
    Then I should receive 200 status code

  Scenario: Retrieve a specific valid User by id
    Given a user exists with a valid id
    When I perform GET operation for "/users/1"
    Then I should see the user's name as "Leanne Graham"

  Scenario: Retrieve a specific valid User by email
    Given a user exists with a valid email
    When I perform GET operation for the email "/users/?email=Sincere@april.biz"
    Then I should see the user's name for the email as "[Leanne Graham]"

  Scenario: Retrieve a specific valid User by username
    Given a user exists with a valid username
    When I perform GET operation for the username "/users/?username=Bret"
    Then I should see the user's name for the username as "[Leanne Graham]"

  Scenario: Retrieve a specific Invalid User by id
    Given only valid users exists
    When I perform GET operation for invalid id "/users" with userId 16767
    Then I should get an null response
    
    

