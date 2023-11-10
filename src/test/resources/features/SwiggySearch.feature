Feature: Search functionality

  @Search
  Scenario: Check if User is able to get suggestions for dish names in Search field
    Given User is on Swiggy Home Page
    And User navigate to search page
    When User searches for "pizza"
    Then Search results for "pizza" are displayed
