# language: en
# encoding: iso-8859-1
Feature: Obtener las ventas realizadas por el vendedor
  Como vendedor del aplicativo quiero ver lista de ventas realizadas

  Scenario: El usuario lista las facturas
    Given que ingreso al API "http://localhost:8080" - vendedor_factura
    And se ubico en la ruta "/vendedor/factura/obtener/1" - vendedor_factura
    And mediante el metodo "GET" - vendedor_factura
    When envio su peticion - vendedor_factura
    Then obtuvo la lista de facturas - vendedor_factura