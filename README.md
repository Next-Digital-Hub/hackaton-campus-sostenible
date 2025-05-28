# Reto: Campus Sostenible – Aplicación Web para la Gestión Sostenible de Residuos
**Objetivo**: Desarrollar una aplicación web que permita visualizar, analizar y gestionar el estado de los contenedores inteligentes del campus, con el fin de optimizar la recogida de residuos y contribuir a una gestión más sostenible.

## Requisitos

- Java 17
- Para instalar las dependencias resuélvelas con el pom `mvn dependency:resolve`

## Ejecutar la aplicacion

Compila y ejecuta el jar o usa `mvn spring-boot:run`

En el estado actual de la aplicacion no se necesita ninguna variable de entorno (la contraseña esta actualmente hardcodeada en vez de en un .env)

Los endpoint a consultar son:

- http://localhost:8080/admin/container (Para dar de alta los contenedores, no esta implementado todavia a partir de json)
- http://localhost:8080/info/container (Para los de mantenimiento)

En sesta version no se ha implementado autenticacion
