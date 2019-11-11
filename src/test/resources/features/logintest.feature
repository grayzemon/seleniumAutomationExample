@loginTestFeature
Feature: As an Automation Tester I want to be able to automate the logging into the Everton FC website so that I can
  demonstrate my understanding of selenium based UI automation


  @loginTestScenario
  Scenario:  login to the demoshop site and verify text shown in a green box on the my account page
    Given I navigate to url "https://www.evertonfc.com/"
    When I login to the site with the credentials "efc11_11_19-1@mailinator.com" and "EvFCS3lAuto"
    Then the homepage will have text that will say "LOGOUT"

