Feature: Check24 Mobilfunk Page Functionality

Background:
    Given User navigates to "https://www.check24.de/"

  Scenario: Check the Mobilfunk page functionality
    Then The user should be able to go to the Mobilfunk page by clicking the button.
    When tariff features are selected, the user should be able to see the tariffs.
    Then the user should be able to add a mobile phone to the plan.
    And the user should  be able to choose a tariff.

