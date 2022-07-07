Feature: Test Api
  como qa automation deseo realizar pruebas a los servicios

  Background:
    Given configuro la url base

  @GetEmpleados
  Scenario Outline: Get Obtener Empleados
    When realizo la peticion al servicio con el recurso <RESOURCES>
    Then valido que el codigo de status sea 200
    Examples:
      | RESOURCES   |
      | /employees  |
      | /employee/1 |

  @PostCreate
  Scenario Outline: Post Crear Empleados
    When configuro el cuerpo y realizo la peticion post al servicio con el recurso <RESOURCES>
      | name   | <NAME>   |
      | salary | <SALARY> |
      | age    | <AGE>    |
    Then valido que el codigo de status sea 200
    Then valido contenido <ETIQUETA><VALOR>
    Examples:
      | RESOURCES | NAME  | SALARY | AGE   | ETIQUETA | VALOR        |
      | /create   | luis  | 50000  | 23654 | status   | success      |
      | /create   | maria | 857584 | 23654 | status   | success full |
      | /create   | maria | 857584 | 23654 | status   | success      |


  @DeleteEmpleados
  Scenario Outline: Delete  Empleados
    When realizo la peticion al servicio con el recurso <RESOURCES>
    Then valido que el codigo de status sea 200
    Then valido contenido <ETIQUETA><VALOR>
    Examples:
      | RESOURCES   | ETIQUETA | VALOR                         |
      | /delete/719 | message  | successfully! deleted Records |
      | /delete/1   | status   | success                       |
      | /delete/2   | message  | successfully! deleted Records |
