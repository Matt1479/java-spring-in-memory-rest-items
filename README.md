# In-Memory REST Items

A simple REST API written in Java, using Spring Framework, that supports CRUD (Create, Read, Update, Delete) operations.

The application uses an in-memory `HashMap` to manage items, so all data is lost once the application stops.

This is a small practice project for learning the fundamentals of building REST APIs with Spring Framework.

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Maven
- Postman

## API Endpoints

| Method | Endpoint    | Description              |
|--------|-------------|--------------------------|
| GET    | /items      | Get all items            |
| GET    | /items/{id} | Get an item by ID        |
| POST   | /items      | Create a new item        |
| PUT    | /items/{id} | Replace an existing item |
| DELETE | /items/{id} | Delete an item           |

## Example

Create an item:

`POST /items`
`Content-Type: application/json`

```json
{
    "name": "Example item"
}
```

Response:

```json
{
    "id": 1,
    "name": "Example item"
}
```

## Run the Application

Maven:

```bash
./mvnw spring-boot:run
```

## Reference

Tutorial: [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service).
