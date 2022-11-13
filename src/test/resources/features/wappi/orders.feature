@Orders
Feature: As a user of wappi web page
  I want to verify the order functionality

  Background:
    Given the user open the web pag
    And the user login with the user mukatyz and password mukatyz123

  Scenario: Verify the product information in the banner
    When try to order a Pan tajado
    Then the user should see the same product information in the dialog before to finish the order

  Scenario: Verify an order with a valid coupon
    When claiming the welcome coupon
    And Close the dialog coupone code
    And ordering Aceite de Girasol, with coupon
    Then the order should be done successfully
    And The order information should appears in the orders screen

  Scenario: Verify an order without coupon
    When ordering Aceite de Girasol, without coupon
    Then the order should be done successfully
    And The order information should appears in the orders screen

  Scenario: Verify an order with an invalid coupon
    When ordering Aceite de Girasol, with invalid coupon
    Then the user should see the error message under the coupon field: Cupón inválido
    Then the user should not see the product in the orders screen





