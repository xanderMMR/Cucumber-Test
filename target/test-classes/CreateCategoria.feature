# language: en
# encoding: iso-8859-1
Feature: Agregar nuevas categorias
  Como administrador del aplicativo quiero agregar nuevas categorias

  Scenario: El administrador agrega las categoria
    Given que ingreso al API "http://localhost:8080" - categoria
    And se ubico en la ruta "/category/create" para agregar - categoria
    And mediante un metodo "POST" para agregar
    And tengo las siguiente categorias para agregar
      | Name    |
      | CategoryTest |
    When envio su peticion para agregar categorias
    Then se insertaron las categorias