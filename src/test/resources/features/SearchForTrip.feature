Feature: Search for a trip
  Scenario:
    Given User open AirCanada
    When User select round trip for 3 adults from "New York" to "Paris" with departure date "3 month" from current date and arrival date "2 month" from departure date
    Then User see the result