Feature: This feature is to make posts using the /posts API

  Scenario: Verify /posts API, User can create a social media post
    Given  A valid user can creating social media posts
    When I perform POST operation using "/posts/", for the specific user
    Then I should receive 201 status code for successful creation
    And I should receive an id for successful creation as 101
    And I should get the same body as posted

  Scenario: Verify Post operation, Invalid User can't create a social media post
    Given  Invalid user performs POST operation for creating social media posts
    When I perform POST operation using "/posts/", for the invalid user
    Then I should receive an empty response

  Scenario: Verify Post operation, Valid User can't create a social media post with semantically invalid body
    Given  A valid user performs POST operation for creating social media posts with semantically invalid body
    When I perform POST operation using "/posts/", for the specific user
    Then I should receive an null response
