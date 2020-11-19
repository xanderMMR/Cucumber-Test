# language: en
# encoding: iso-8859-1
Feature: Actualizar determinado producto
  Como vendedor del aplicativo quiero actualizar mis productos

  Scenario: El vendedor actualiza los productos
    Given que ingreso al API "http://localhost:8080" para actualizar productos
    And se ubica en la ruta "/producto/actualizar/18" para actualizar productos
    And mediante el metodo "PUT" para actualizar productos
    And tengo el siguiente producto para actualizarlo
      | Name | Description | Tags | Stock| Price |
      | Vaso | Vaso de barro | Manualidades |  9  | 13.3 |

    When envio su peticion para actualizar producto
    Then se actualiza el producto