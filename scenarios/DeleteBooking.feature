@bookerAPI @deleteBooking
@Author:Hrithik
Feature: To delete a booking in restful-booker

  Background: create an auth token
    Given user has access to endpoint "/auth"
    When user creates a auth token with credential "admin" & "password123"
    Then user should get the response code 200

  @deleteBookingIDs
  Scenario: To delete a booking
    Given user has access to endpoint "/booking"
    And user makes a request to view booking IDs
    When user makes a request to delete booking with basic auth "admin" & "password123"
    Then user should get the response code 201

