# language: en
# encoding: iso-8859-1
Feature: Agregar nuevos vendedores
  Como usuario del aplicativo quiero registrarme como vendedor

  Scenario: El usuario intenta registrarse como vendedor
    Given que ingreso al API "http://localhost:8080" para agregar - vendedor
    And se ubico en la ruta "/vendedor/registrar" para agregar - vendedor
    And mediante el metodo "POST" para agregar - vendedor
    And tengo el siguiente vendedor para agregar - vendedor
      | Address | Date | DNI | Email | N_mobile | Name | Password | Username | Lastname |
      | Esquina12 | 12/11/2020 | 4227777 | 24f423342fashg@gmail.com | 987154321 | Arturo |FNJSDDJKMCn | Ulhfsfsduffr13| Medina |
    When envio su peticion para agregar - vendedor
    Then se registro vendedor