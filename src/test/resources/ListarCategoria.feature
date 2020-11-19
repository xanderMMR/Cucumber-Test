# language: en
# encoding: iso-8859-1
Feature: Listar categorias registradas
  Como usuario del aplicativo quiero ver el listado de categorias

  Scenario: El administrador lista los categorias
    Given que se ingreso al API "http://localhost:8080"
    And  y se ubico en la ruta "/category/get"
    And mediante un metodo "GET"
    When envio su peticion para listar las categorias
    Then obtuvo la lista de categoria