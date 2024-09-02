Feature: Search for post code

#  Background: User search for post code finder


  Scenario Outline: Some name
    Given User open Google
    When User enter "search for post code" in the Google search field
    Given User open first link on the page
    When User enter "<country>" in the postcode search field
    Then User able to see the list of results

    Examples:
      | country |
      | Poland  |
      | Ukraine |
      | Germany |