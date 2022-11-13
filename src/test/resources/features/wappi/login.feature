@Login
Feature: As a user of wappi web page
  I want to Login to the web page to use the different components offered

  Background:
    Given the user open the web pag

  Scenario: navigate to wappi and verify the required fields
    When clicking on the username and password fields
    Then the user should see the error message under the username field: El usuario es requerido
    And the user should see the error message under the password field: La contraseña requerida

  Scenario: navigate to wappi and verify the disable login button
    When clicking on the username and password fields
    Then the user should disabled the login button

  Scenario: navigate to wappi and login successfully
    When enter the user mukatyz and password mukatyz123
    And clicking on login button
    Then the user should see the main page


  Scenario: navigate to wappi and validate the password field
    When enter the user mukatyz and password mukatyz
    And clicking on login button
    Then the user should see the error message under the password field: La contraseña debe contener entre 8 y 14 caracteres

  Scenario Outline: navigate to wappi and validate the username field
    When enter the user <username> and password <password>
    And clicking on login button
    Then the user should see the error message under the <field> field: <errorMessage>
    Examples:
      | username | password  | field    | errorMessage                                     |
      | *        | katy12345 | username | El usuario debe ser alfanumérico                 |
      |          | katy12345 | username | El usuario es requerido                          |
      | 2        | katy12345 | username | El usuario debe contener entre 6 y 20 caracteres |
      | katy_1   | katy12345 | username | El usuario debe ser alfanumérico                 |




