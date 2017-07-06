Feature: Login
  As an user I should receive proper server responses

  @loginError
  Scenario Outline: A customer should receive the relevant
    error code upon login

    When a user tries to login with "<credentials>"
    Then the error status code should be "<code>"

    Examples: 
      | credentials | code |
      | valid       |  200 |
      | invalid     |  403 |
