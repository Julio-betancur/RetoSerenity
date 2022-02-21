#language: en
Feature: Registration and purchase

  Background:
    Given that Maria is in the homepage of advantageOnlineShopping https://www.advantageonlineshopping.com/

@Registro
  Scenario Outline: successful registration
    When she enters her credentials
      | usuario    | correo              | clave       | confirmClave | nombre | apellido | celular    | pais     | ciudad   | direccion        | departamento | codigoPostal |
      | <username> | testingA11@gmail.com | Testing1234 | Testing1234  | Julio  | Betancur | 3003568545 | Colombia | Medellin | Calle 48 sur #35 | Antioquia    | 458696       |
    Then she can validate that her <username> was succesfully registered

    Examples:
      | username  |
      | testingA11 |

@Compra @dev
  Scenario: successful purchase
    When she logs in and buys a computer
      | usuario   | clave       |
      | testingA10 | Testing1234 |
    Then she can validate that the chosen computer corresponds to that of the payment order

