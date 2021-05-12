Feature: GuiPagesTests

  @GuiTest
  Scenario: Checkboxes page
    When I navigate to checkboxes page
    And I tick checkboxes
      | 1 | 2 |
    Then I verify checkboxes state
      | checked | unchecked |
      | 1       | 2         |
    And I refresh the page
    Then I verify checkboxes state
      | checked | unchecked |
      | 2       | 1         |

  @GuiTest
  Scenario: IFrames page
    When I navigate to iframe page
    And I type name Kirill inside iframe
    Then I verify that name Kirill is shown
