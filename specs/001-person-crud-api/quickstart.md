# Quickstart: Person Records Service

## Prerequisites

- Java 25 installed and available on PATH
- Maven installed

## Run the service

```bash
mvn spring-boot:run
```

The service starts on `http://localhost:8080`.

## Example requests

Create a person:

```bash
curl -X POST http://localhost:8080/persons \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Ada","lastName":"Lovelace","email":"ada@example.com"}'
```

List persons:

```bash
curl http://localhost:8080/persons
```

Get by ID:

```bash
curl http://localhost:8080/persons/1
```

Update a person:

```bash
curl -X PUT http://localhost:8080/persons/1 \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Ada","lastName":"Byron","email":"ada@example.com"}'
```

Delete a person:

```bash
curl -X DELETE http://localhost:8080/persons/1
```
