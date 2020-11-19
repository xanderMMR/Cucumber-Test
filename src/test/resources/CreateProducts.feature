# language: en
# encoding: iso-8859-1
Feature: Agregar nuevos productos
  Como vendedor del aplicativo quiero agregar nuevos productos

  Scenario: El vendedor agrega los productos
    Given que ingreso al API "http://localhost:8080" para agregar
    And se ubico en la ruta "/vendedor/producto/registrar/1" para agregar
    And mediante el metodo "POST" para agregar
    And tengo el siguiente producto para agregar
      | Name | Description | Tags | Stock| Price |
      | Prueba | Pruebita | Manualidades |  19  | 12.3 |
    When envio su peticion para agregar
    Then se insertaron los productos