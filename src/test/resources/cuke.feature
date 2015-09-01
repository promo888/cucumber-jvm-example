@sample1
Feature: SampleTest

@Sanity
Scenario: SampleRun
Given Test "testScenario"
When I start CukeTest "testName"
Then I report "testStatus"

@Sanity
Scenario: SampleRun2
Given Test "testScenario2"
When I start CukeTest "testName2"
Then I report "testStatus2"

@Sanity
Scenario: SampleRun3
Given Test : "|Sanity| |Regression| |Stress|"
When I start CukeTest "testName3"
Then I report "testStatus3"


@Regression
Scenario Outline: Add invalid bank account displays inline errors
  Given _cuke I follow "Add Bank Account"
  When _cuke I fill in "<field>" with "<value>"
   And _cuke I click "Add Bank Account"
  Then _cuke I should see the inline error "<error>" for "<field>" with value "<value>"

  Examples:
    | field   | value         | error                    |
    | Account | 123456789012  | passed                   |
    | Account |               | Can't be blank           |
    | Account | Sixty five    | Should be 1 to 12 digits |
    | Account | 1234567890123 | Should be 1 to 12 digits |