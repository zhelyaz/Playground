Feature: Calculator
  As a user I would like to estimate
  my savings using the calulator

  @calculator
  Scenario: A user can calculate his savings
    Given a user is on the calculator page
    And the user updates the current score to 50
    When he selects the score goal to be 680
    Then his current score should be:
      | interest_rate | costs | cards_availale |
      | 36.5%         | £849  |             22 |
    And his score goal should be
      | interest_rate | costs | cards_availale |
      | 20%           | £465  |            241 |
    And the user potential savings are 384 GBP
