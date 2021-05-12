Feature: ApiSampleTests

  #few tests from https://goweather.herokuapp.com/weather
  Scenario: Verify weather call is succesful
    When I execute weather request to Paris city
    Then I verify response status is 200
    Then I verify that temperature property isNot empty

  Scenario: Verify weather not existing city
    When I execute weather request to blablacity city
    Then I verify response status is 200
    Then I verify that temperature property is empty

  Scenario: Verify temperature value is within reasonable range
    When I execute weather request to Paris city
    Then I verify that temperature is more than -40 and less than 50
