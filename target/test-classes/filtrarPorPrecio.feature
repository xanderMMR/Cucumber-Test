# language: en
# encoding: iso-8859-1
Feature: Filtrar productos registrados de acuerdo al precio
  Como comprador del aplicativo quiero filtrar productos por precio

  Scenario: El comprador lista los productos de acuerdo a su precio
    Given que ingreso al API "http://localhost:8080" - FP
    And se ubico en la ruta "/producto/buscar/20/60" - FP
    And mediante el metodo "GET" - FP
    When envio su peticion - FP
    Then obtuvo la lista de productos de acuerdo a su filtro - FP