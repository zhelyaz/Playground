Feature: Cookies
  As new user I would like to be notified about
  the cookie policy on the website

  @bannerPresent
  Scenario: A new user can see the cookie usafe policy
    Given clearscore website is loaded
    Then I should be notified about the cookie usage policy

  @bannerDismissed
  Scenario: A new user can hide the cookie notification
    Given clearscore website is loaded
    When a new user acknolwdges the cookie policy
    Then the cookie notification should disappear
    And the appropriate cookie should be set

  @bannerNotAppearing
  Scenario: A new user can hide the cookie banner
    Given clearscore website is loaded
    When a new user acknolwdges the cookie policy
    Then the cookie notification should disappear
    When the page is reloaded
    Then the cookie notification should not appear
    And the appropriate cookie should be set
