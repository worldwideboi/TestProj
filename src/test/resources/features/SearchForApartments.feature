Feature: Search for apartments
  Scenario:
    Given User open Airbnb
    When User search for apartments in "Paris,France" with checkIn date "2 month" from current date and checkOut date "3 month" from checkIn for 3 adults
    Then User see the results