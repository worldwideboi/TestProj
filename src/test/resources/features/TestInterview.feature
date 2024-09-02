Feature: User search for apartments
  Scenario:
    Given User open Booking
    When User search for apartments in "Paris" with checkIn  "2 month" from current date and checkOut date "1 month" from checkIn for 7 adults
    Then User able to see the result page