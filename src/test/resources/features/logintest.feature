@loginValidationFeature
Feature: As an Automation Tester I want to be able to automate the logging into the Everton FC website so that I can
  demonstrate my understanding of selenium based UI automation

  @invalidLoginScenarios
  Scenario Outline:  Attempt to login to the Everton site with invalid credentials and verify error text is as expected.
    Given I navigate to url "https://www.evertonfc.com/"
    When I login to the site with the credentials "<UserName>" and "<Password>"
    Then an error message will be returned containing "<ErrorText>" for "<Scenario>"

    Examples:
      | Scenario         | UserName                     | Password    | ErrorText                               |
      | Missing Username |                              | EvFCS3lAuto | This value is required                  |
      | Missing Password | validemailaddr@test.com      |             | This value is required                  |
      | Invalid Login    | nonexistuser@test.com        | Pa55w0rd!   | Your username or password was incorrect |
      | Invalid Login    | efc11_11_19-1@mailinator.com | Pa55w0rd!   | Your username or password was incorrect |

  @validLoginScenario
  Scenario:  Login to the Everton site and verify that the user is logged in
    Given I navigate to url "https://www.evertonfc.com/"
    When I login to the site with the credentials "efc11_11_19-1@mailinator.com" and "EvFCS3lAuto"
    Then the homepage will have text that will say "LOGOUT"
