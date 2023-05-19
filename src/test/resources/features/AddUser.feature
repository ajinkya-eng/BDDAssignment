Feature: Verify adding user functionality in Orange HRM application

  @test
  Scenario: Verify whether user is getting added and then deleted successfully
    Given I am on Orange HRM login page
    When I enter login credentials
    And I click on "Submit" button on "Login" page
    Then I should see HomePage of Orange HRM
    When I click on "Admin" button on "Home" page
    And I click on "Add" button on "Home" page
    And I enter user details as below
      | Role  | Name | Status  | Username     | Password  |
      | Admin | Alfy | Enabled | jadine12jack | Xyz@12345 |
    Then I should see User "jadine12jack" details in Records Found List
    And I select checkbox to Delete User "jadine12jack"
    And I click on Delete button for User "jadine12jack"
    Then I should not see User "jadine12jack" details in Records found List
