Feature: Get Booking API testing

  Scenario Outline: Authentication
    Given I have a valid booking API endpoint
    When I send request for authentication
    Then the response status code should be <statusCode>
    Examples:
      | statusCode |
      | 200        |

  Scenario: Get Bookings
    Given I have a valid booking API endpoint
    When I send a GET request to retrieve all bookings
    Then the response status code should be 200
#    And the response should contain booking details