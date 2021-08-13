Feature: OLX search and print results
  Scenario: As a user I want to search apartments on OLX and print specific results
    Given the user navigates to OLX
    When the user searches for apartments
    Then the user will get a list of apartments
