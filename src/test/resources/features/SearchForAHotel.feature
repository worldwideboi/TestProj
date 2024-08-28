Feature: Search for apartments
  Scenario: User search for a hotel
    Given User open AirBnb
    When User search for a hotel in "Paris, France"
    Then User see the result page with results
    