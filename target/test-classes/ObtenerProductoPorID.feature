# language: en
# encoding: iso-8859-1
Feature: Listar productos registrados
  Como usuario del aplicativo quiero ver el listado de productos

  Scenario: El usuario lista los productos
    Given que ingreso al API "http://localhost:8080" para obtener
    And se ubico en la ruta "/producto/obtener/3" para obtener
    And mediante el metodo "GET" para obtener
    When envio su peticion para obtener por ID
    Then obtuvo el producto