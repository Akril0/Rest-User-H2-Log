Rest-Employee-H2-Log
======================

REST API Spring Boot демо-приложение
+ логирование.

H2 Database
--------------
https://www.h2database.com/html/main.html

База данных H2 — СУБД, написанная на Java.
Основные особенности:
- Очень быстрая, с открытым исходным кодом, JDBC API.
- Встроенный и серверный режимы; базы данных в памяти
(in memory) - хранит данные в системной памяти,
а не на диске.
- Консольное приложение на основе браузера.
- Небольшой размер: размер файла jar около 2,5 МБ.


Создаем Spring Boot приложение
--------------------------------

1) Заходим https://start.spring.io/

2) Конфигурируем проект:
  a) Project: Maven Project
  b) Spring Boot: 2.7.1
  c) Project Metadata:
    Group: com.example.app
    Artifact: Rest-Employee-H2-Log
    Description: можем оставить так
    Packaging: Jar
    Java: 18
  d) Dependencies:
    Spring Web
    Spring Data JPA
    H2 Database
    Spring Boot DevTools

  * Spring Boot по умолчанию включает spring-boot-starter-logging
    в качестве транзитивной зависимости для модуля spring-boot-starter.
    По умолчанию - это SLF4J вместе с реализациями Logback.
    Logback Project   https://logback.qos.ch/
    SLF4J             https://www.slf4j.org/

3) Проверяем. Жмем GENERATE.

4) Сформированный zip-файл распаковываем,
проект перемещаем в папку проектов.

5) Открываем проект в IDE. Исследуем
    src/main/
    pom.xml

6) Модифицируем
    RestEmployeeH2LogApplication

7) Добавляем необходимые пакеты и классы:
	/entity/Employee
	/repository/EmployeeRepository
	/service/EmployeeService
	/controllers/EmployeeController

8) Вносим необходимые изменения в
	application.properties

9) Запускаем приложение и смотрим логи.
Должны получить в консоли
H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:employeesdb2'
это доступность консоли H2

10) В браузере вводим
localhost:8080/h2-console
Получим интерфейс H2.



Тестируем REST API
----------------------
Сообщения о логировании будут появляться
после REST-запроса.

Используем Postman (инструмент
тестирования REST API)
https://www.postman.com/

Запустим код в IDE.

1) REST-запрос на получение данных.
Но получим пустой массив, поскольку
данные еще не вносились

GET http://localhost:8080/api/employees


2) REST-запрос на создание данных

POST http://localhost:8080/api/employees

Настройки в Postman: Body, raw, JSON.
Прописываем в отправке каждый раз отдельно


{
	"name": "Alice",
	"email": "alexbatin2003@gmail.com",
	"phone": "555 123-4587"
}


{
	"name": "Lucy",
	"email": "alexbatin2003@gmail.com",
	"phone": "555 111-9944"
}

{
	"name": "Jessica",
	"email": "alexbatin2003@gmail.com",
	"phone": "555 777-1234"
}

{
	"name": "Robert",
	"email": "alexbatin2003@gmail.com",
	"phone": "555 012-7833"
}

{
	"name": "John",
	"email": "alexbatin2003@gmail.com",
	"phone": "555 621-7711"
}


3) REST-запрос на получение данных по id

GET http://localhost:8080/api/employees/2


4) REST-запрос на обновление данных по id

PUT http://localhost:8080/api/employees

{
	"id": 5,
	"name": "John",
	"position": "manager",
	"phone": "555 999-3333",
	"salary": 2000.00
}



5) REST-запрос на удаление данных по id

DELETE http://localhost:8080/api/employees/4

