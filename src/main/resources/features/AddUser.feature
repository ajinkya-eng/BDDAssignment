Feature: Verify adding user functionality in Orange HRM application

  @test
  Scenario: Verify whether user is getting added successfully
    Given I am on Orange HRM login page
    When I enter username as Admin
    And I enter password as admin123
    And I click on Submit
    Then I should see HomePage of Orange HRM
    When I click on Admin option
    And I click on Add button
    And I enter user details