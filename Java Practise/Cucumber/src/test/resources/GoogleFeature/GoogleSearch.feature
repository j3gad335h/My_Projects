Feature: Checking Google Search Function

  Scenario: Validate Google Search Function
    When browser is open
    And user is on google search page
    When user enter text in search box
    And enters keys
    Then user navigated to results page