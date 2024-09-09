Feature: Pruebas de API de Gestión de Usuarios

  Scenario: Listar todos los usuarios
    Given que la API está disponible
    When solicito la lista de usuarios
    Then debería ver al menos un usuario en la respuesta

  Scenario: Registrar un nuevo usuario
    Given que la API está disponible
    When registro un nuevo usuario con detalles válidos
    Then debería ver que el usuario se registró exitosamente

  Scenario: Intentar registrar un usuario sin detalles obligatorios
    Given que la API está disponible
    When intento registrar un usuario sin proporcionar detalles obligatorios
    Then debería recibir una respuesta de error

  Scenario: Actualizar un usuario existente
    Given que la API está disponible
    When actualizo los detalles de un usuario existente
    Then los detalles deberían actualizarse correctamente

  Scenario: Eliminar un usuario
    Given que la API está disponible
    When elimino un usuario
    Then el usuario debería ser eliminado exitosamente
