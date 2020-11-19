# language: en
# encoding: iso-8859-1
Feature: Agregar nuevos compradores
  Como usuario del aplicativo quiero registrarme como comprador

  Scenario: El usuario intenta registrarse como comprador
    Given que ingreso al API "http://localhost:8080" para agregar - comprador
    And se ubico en la ruta "/comprador/register" para agregar - comprador
    And mediante el metodo "POST" para agregar - comprador
    And tengo el siguiente vendedor para agregar - comprador
      | Address | Date | DNI | Email | N_mobile | Name | Password | Username | Lastname |
      | Esquina12 | 12/11/2020 | 24177732 | fd23sshrg@gmail.com | 987154321 | Arturo |FNfsDDJKMCn | powee3| Medina |
    When envio su peticion para agregar - comprador
    Then se registro comprador