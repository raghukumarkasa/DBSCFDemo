Feature: Validate content in J.P. Morgan home page

  
  Scenario: Validate logo in J.P. Morgan landing page
    Given I launch google
    And search for the keyword "J.P. Morgan"
    When I click on the first search result
    Then validate that the right logo is displayed in the landing page