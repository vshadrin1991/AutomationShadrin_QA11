Feature: Mood Panda test

  # This is smoke test
  @smoke
  Scenario: Check login page
    Given i load page
    When i click get started
    When i enter user "<UserName>"
    When i enter password "<UserPassword>"
    When i click on login button
    Then check login exception
    But check login exception "Invalid  email address"
    Then i close
