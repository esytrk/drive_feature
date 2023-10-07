Feature: Drive Feature
  User Story: A user should be able to display "My Drive" and "All Documents" modules.
  Users: Human Resources User, Helpdesk User, Marketing User


  @SCRUM-1267
  Scenario Outline: As a "<user>" be able to display "My Drive" and "All Documents"
    Given "<user>" user logins the website
    When User clicks on the "Drive" module
    Then "My Drive" module is displayed
    And "All Documents" module is displayed

    Examples:
      | user      |
      | HR        |
      | Marketing |
      | HelpDesk  |