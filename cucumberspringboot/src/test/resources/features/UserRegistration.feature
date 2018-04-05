@Web
Feature: User Registration

  Background: Prerequisites
    Given the user is on Registration page
    And he has the registration details

#    the scenario is very abstract in terms of actions, a good example of a BDD scenario
  Scenario: Normal registration flow
    When the user fills in the registration page
    And he submits the registration details
    Then he should see a success message

#    the following scenario is a bit verbose in terms of fields used:
  Scenario Outline: Registration without filling a mandatory field
    Given the user is lacking <fieldName>
    When the user fills in the registration page
    And he submits the registration details
    Then he should see an error message for <fieldName> field with message: * This field is required

    Examples:
      | fieldName |
      | UserName  |
      | Hobbies   |