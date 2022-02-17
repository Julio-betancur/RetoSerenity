#language: en
Feature: Registration and purchase

  Background:
    Given that Maria is in the homepage of advantageOnlineShopping https://www.advantageonlineshopping.com/


  Scenario Outline: successful registration
    When she enters her credentials
      | usuario    | correo              | clave       | confirmClave | nombre | apellido | celular    | pais     | ciudad   | direccion        | departamento | codigoPostal |
      | <username> | testingA9@gmail.com | Testing1234 | Testing1234  | Julio  | Betancur | 3003568545 | Colombia | Medellin | Calle 48 sur #35 | Antioquia    | 458696       |
    Then she can validate that her <username> was succesfully registered

    Examples:
      | username  |
      | testingA9 |


  Scenario: successful purchase
    When she logs in and buys a computer
      | usuario   | clave       |
      | testingA9 | Testing1234 |
    Then she can validate that the chosen computer corresponds to that of the payment order

