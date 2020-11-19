# language: en
# encoding: iso-8859-1
Feature: Listar productos registrados
  Como usuario del aplicativo quiero ver el listado de productos

  Scenario: El usuario lista los productos
    Given que ingreso al API "http://localhost:8080"
    And se ubico en la ruta "/producto/listar"
    And mediante el metodo "GET"
    When envio su peticion
    Then obtuvo la lista de productos