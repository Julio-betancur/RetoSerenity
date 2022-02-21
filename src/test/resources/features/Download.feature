#language: en
  Feature: user download their statements
    @pdf
    Scenario: User download their statement for last month
      Given Maria has made purchases with his credit card
      And she already downloaded her statements
      When she reviews her transactions
      Then she should see the transactions for last month