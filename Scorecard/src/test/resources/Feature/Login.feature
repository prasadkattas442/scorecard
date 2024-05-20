Feature: Validating Login functionality of Scorecard Page

  Scenario Outline: Validating EmployeeId with valid credentials
    Given user is on Nisum Scorecard Login Page
    When user provide "<EmployeeId>"
    And Click on Submit button
    Then Verify title of Scorecard homepage
    Examples:
      | EmployeeId |
      | 16020      |
      | 41689      |

  @y
  Scenario Outline: Validating EmployeeId with valid credentials using enter key
    Given user is on Nisum Scorecard Login Page
    When user provide "<EmployeeId>"
    And press tab and then enter key for submit button
    Then Verify title of Scorecard homepage
    Examples:
      | EmployeeId   |
      | 16020 654    |
      | 41689    654 |


  Scenario Outline: Validating EmployeeId with Invalid credentials
    Given user is on Nisum Scorecard Login Page
    When user provide "<EmployeeId>"
    And Click on Submit button
    Then Verify Failure message of Scorecard Login Page "Not Authorized"
    Examples:
      | EmployeeId |
      | 1          |
      | 6984321    |
      | hsdgjkhdf  |
      | @#$#^%$^%$ |
      | hrtdg2345# |
      |            |