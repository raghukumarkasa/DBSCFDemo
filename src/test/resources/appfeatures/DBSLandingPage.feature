Feature: Validate content in DBS home page

@sanity
  Scenario: Validate logo in DBS landing page
    Given I launch google
    And search for the keyword "DBS"
    When I click on the first search result
    Then validate that the right logo is displayed in the landing page
    
@smoke
  Scenario: Validate Digibank login option is displayed in DBS landing page
    Given I launch google
    And search for the keyword "DBS"
    When I click on the first search result
    And I click on Login button
    Then validate that digibank by DBS is displayed under login options
