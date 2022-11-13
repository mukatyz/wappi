# Wappi web page Automation Test

This project contains a structure ready to implement automated test cases using Cucumber, integrated with Selenium and Serenity BDD, using the Screenplay desing pattern

## Setting up yourself

- You need a personal GitLab account: https://gitlab.com/users/sign_up
- Make sure you have JDK 11 or newer installed in your environment and the variable environment respective
- Maven 3.3 or newer is also required
- You should have Chrome or Chromium installed in your system
- Fork this project into your personal Gitlab account
- Clone the project from your personal Gitlab repository into your local environment
- Install the dependencies using Gradle

## Test

In this case were created functional test cases for the main components

- Login
  Feature: src\test\resources\features\wappi\login.feature
  Runner: src\java\wappi\runners\Login.class
- Orders
  Feature: src\test\resources\features\wappi\orders.feature
  Runner: src\java\wappi\runners\Orders.class
- Coupon
  Feature: src\test\resources\features\wappi\Coupon.feature
  Runner: src\java\wappi\runners\coupon.class
- Profile information
  Feature: src\test\resources\features\wappi\profile.feature
  Runner: src\java\wappi\runners\Profile.class


