Feature: Search for post code

  Background: User search for post code finder
    Given User open Google
    When User enter "search for post code" in the Google search field

  Scenario: Some name
    Given User open first link on the page
    When User enter "Poland" in the postcode search field
    Then User able to see the list of results