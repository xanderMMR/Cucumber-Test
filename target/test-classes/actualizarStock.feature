# language: en
# encoding: iso-8859-1
Feature: Actualizar stock de determinado producto
  Como vendedor del aplicativo quiero actualizar mi stock

  Scenario: El vendedor actualiza el stock
    Given que ingreso al API "http://localhost:8080" para actualizar mi stock
    And se ubica en la ruta "/producto/actualizarStock/31" para actualizar stock
    And mediante el metodo "PUT" para actualizar stock
    And tengo el siguiente producto para actualizar mi stock
      | Stock |
      |  5 |
    When envio su peticion para actualizar stock de producto
    Then se actualiza el stock del prodducto