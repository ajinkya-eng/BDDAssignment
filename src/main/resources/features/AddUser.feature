Feature: Verify adding user functionality in Orange HRM application

  @test
  Scenario: Verify whether user is getting added successfully
    Given I am on Orange HRM login page
    When I enter login credentials
    And I click on "Submit" button on "Login" page
    Then I should see HomePage of Orange HRM
    When I click on "Admin" button on "Home" page
    And I click on "Add" button on "Home" page
    And I enter user details as below
      | Role  | Name | Status  | Username    | Password  |
      | Admin | Odis | Enabled | odisAdalwin | Xyz@12345 |