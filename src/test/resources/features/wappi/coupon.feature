@Coupon
Feature: As a user of wappi web page
  I want to verify the coupon options

  Background:
    Given the user open the web pag
    Given the user login with the user mukatyz and password mukatyz123
    When claiming the welcome coupon

  Scenario: Get a welcome coupon
    Then the coupon code should be showed

  Scenario: Verify the welcome coupon information
    When Go to the orders page
    Then the coupon information should be right

  Scenario: Verify the coupone count when is used
    When Close the dialog coupone code
    And ordering Aceite de Girasol, with coupon
    Then the coupon uses should be 0

  Scenario: Verify the welcome coupon when relogin
    When the user log out
    And login again
    Then the welcome coupon shouldn't appears


    

