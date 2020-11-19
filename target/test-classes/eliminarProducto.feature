# language: en
# encoding: iso-8859-1
Feature: Eliminar productos
  Como vendedor del aplicativo quiero eliminar mis productos

  Scenario: El vendedor elimina los productos
    Given que ingreso al API "http://localhost:8080" para eliminar
    And se ubico en la ruta "/producto/eliminar/36" para eliminar
    And mediante el metodo "DELETE" para eliminar
    When envio su peticion para eliminar
    Then se eliminaron los productos