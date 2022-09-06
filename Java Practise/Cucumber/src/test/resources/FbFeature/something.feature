@EndtoEnd
Feature: Verify Amazon Website

  Background: Launch the Browser
    Given Launch the Browser
    And Get Amazon url "https://www.amazon.in/"

  @smokeTesting
  Scenario: Verify Browser Opens or Not
    And Get Amazon url "https://www.amazon.in/"

  @FunctionTesting-Search
  Scenario: Verify Search Function
    When user in in Amazon Website
    And Search something "TV"
    Then Validate Search Function

  @FunctionTesting-RetursAndOrder
  Scenario: Verify Sell Function
    When user in in Amazon Website
    And Click Returns and Order

  @outline
  Scenario Outline: Validate Multiple Keyword
    When user in in Amazon Website
    And Search something called "<KeyWord>"

    Examples: 
      | KeyWord  |
      | TV       |
      | Mobile   |
      | Computer |
      | Laptop   |
