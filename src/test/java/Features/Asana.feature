Feature: Testing New Asana project
  Scenario: Get workspace details: gid
    Given I have workspace object
    When  User perform astana GET workspace operation
    Then  User is able to see response with workspace details
