# Web service technologies, Laboratory work #4

## Task description

> Необходимо выполнить задание из первой работы, но с использованием
> REST-сервиса. Таблицу базы данных, а также код для работы с ней можно оставить
> без изменений.

## Requirements

- Java 8
- Maven 3+
- Glassfish 4.0
- Postgresql 9.3+

## Getting started

Start with typing 

`mvn clean install`

in project root directory.

## Project structure

The project consists of some modules:

- data-access -- all database-related code (entity classes, data access objects, utilities for query generation)
- exterminatus-service -- implementation of JAX-WS service
- standalone-jaxws -- standalone version of exterminatus service
- jaxws-client -- console client for web service
