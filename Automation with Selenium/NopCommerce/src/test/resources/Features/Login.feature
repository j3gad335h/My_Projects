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
Feature: Verify Login Feature
  I want to use this template for my feature file

  @SmokeTest
  Scenario: Launch url
    Given User Opens "https://admin-demo.nopcommerce.com/"

  @RegressionTest
  Scenario: Verify Login Function
    Given User Opens "https://admin-demo.nopcommerce.com/"
    When User enters email as "admin@yourstore.com" and password as "admin"
    And User Clicks Login
    Then Page Title Should be "Dashboard / nopCommerce administration"
    Then User Click Logout
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
