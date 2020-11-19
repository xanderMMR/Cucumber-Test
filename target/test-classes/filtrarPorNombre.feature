# language: en
# encoding: iso-8859-1
Feature: Filtrar productos registrados de acuerdo a su nombre
  Como comprador del aplicativo quiero filtrar productos por nombre

  Scenario: El comprador lista los productos de acuerdo a su nombre
    Given que ingreso al API "http://localhost:8080" - FN
    And se ubico en la ruta "/producto/buscar/ga" - FN
    And mediante el metodo "GET" - FN
    When envio su peticion - FN
    Then obtuvo la lista de productos de acuerdo a su filtro - FN