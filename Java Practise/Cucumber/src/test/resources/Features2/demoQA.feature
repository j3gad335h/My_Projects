#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Test login functionality

  Scenario Outline: Check login is Successful with valid credentials
    Given Browser is open
    Then User is on login page
    When User enters Username as " Admin" and Password as "admin123"
    And user click the login

  Scenario Outline: Check login is Successful with valid credentials
    Given Browser is open
    Then User is on login page
    When user enters '<username>' and '<password>'
    And user click the login

    Examples: 
      | username | password |
      | Admin    | admin123 |
      | admin    | admin123 |
