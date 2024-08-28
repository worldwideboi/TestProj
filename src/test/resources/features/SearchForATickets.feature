Feature: Select a trip

  Background: User select
    Given User open Aircanada
    Then User on the main page

    Scenario: User select a round trip
      Given Airbnb website is opened
      When User select a round trip for "2" Adults from "New York" to "Paris" with departure date and return date
      And User select lowest Economy Basic fare on Departing Page Flight page
      And User select lowest Economy Basic fare on Return Page Flight page
      Then User see Trip review page with a timer and selected Flights