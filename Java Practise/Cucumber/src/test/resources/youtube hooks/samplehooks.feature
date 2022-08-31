Feature: Login Feature

  Scenario: Verify Login feature
    Given broswer is in facebook Page
    When user enters email and password
    And user click login button
    Then user navigated to home page