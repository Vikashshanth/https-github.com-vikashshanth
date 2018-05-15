@regression
Feature: Sample scenarios to test LeanFT installation and work flow

  @WebApplication
  Scenario Outline: Successful Login with Valid Credentials in web application
    Given User is on "Home" Page
    When User logs in using username as "<uname>" and password as "<pwd>"
    Then login should be successful
    When User presses Sign Out button
    Then logout should be successful

    Examples:
      | uname    | pwd      |
      | tutorial | tutorial |
      | leanft   | leanft   |

  @DesktopApplication
  Scenario Outline: Successful to open Calculator/desktop application perform math operation
    Given Calculator desktop application is available
    When user performs "<Operation>" on "<Param1>" and "<Param2>"
    Then Validates the Results

    Examples:
      |Operation  |Param1 |Param2    |
      |Add        |2      |3        |