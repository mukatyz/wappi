@Profile
Feature: As a user of wappi web page
  I want to verify the profile option

  Background:
    Given the user open the web pag
    And the user login with the user mukatyz and password mukatyz123
    When Go to profile screen

  Scenario: Verify the fields in the profile screen when is just opened
    Then the user should see the fields with information

  Scenario: Verify the fields validations in the profile screen
    When enter the information in the fields
      | image | name  | lastName | bornDate | country     | sex  |
      | null  | kate1 | munoz*   | 12123    | Seleccionar | null |
    And the user save the profile information
    Then the user should see the error message under the fields

  Scenario: Verify the success change of the profile information
    When enter the information in the fields
      | image             | name | lastName | bornDate   | country  | sex      |
      | profile_image.jpg | kate | munoz    | 12/12/1995 | Colombia | Femenino |
    And the user save the profile information
    Then should see the confirmation message

  Scenario: Verify the success change of the profile information
    When enter the information in the fields
      | image             | name | lastName | bornDate   | country  | sex      |
      | profile_image.jpg | kate | munoz    | 12/12/1995 | Colombia | Femenino |
    And the user save the profile information
    And go out and come back to the profile screen
    Then the user should see the last profile information saved

  Scenario: Verify the cancel button in the profile screen
    When enter the information in the fields
      | image             | name | lastName | bornDate   | country  | sex      |
      | profile_image.jpg | kate | munoz    | 12/12/1995 | Colombia | Femenino |
    And the user do not save the profile information
    Then the user should see the profile information for default



