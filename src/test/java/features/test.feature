Feature: Login Feature

  Background: User should be on the Guru99 Banking Page
    Given User on the Guru99 Banking Page

  Scenario: TC-101 User should be able to login with valid username and password


    When User enters valid username
    And User enters valid password
    And User click on login button
    Then User successfully logged in


  Scenario Outline: TC-102 User should not be able to login with invalid username and invalid password

    When User enter <userName>
    And User enters <password>
    And User click on login button
    Then User fails to log in

    Examples:

      |userName |password |
      |"gadhagd"| "adghga"|