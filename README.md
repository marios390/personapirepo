# Person Records Service

REST API for managing person records.

## Run

```bash
mvn spring-boot:run
```

Service listens on `http://localhost:8080`.

H2 console is available at `http://localhost:8080/h2-console`.

## Endpoints

- `GET /persons` - list all persons
- `GET /persons/{id}` - get a person by id
- `POST /persons` - create a person
- `PUT /persons/{id}` - update a person
- `DELETE /persons/{id}` - delete a person
- `GET /persons/search?lastName={value}` - search persons by last name substring

## Error format

### Not found

```json
{
  "message": "Person not found: 123"
}
```

### Validation error

```json
{
  "message": "Validation failed",
  "fieldErrors": [
    {
      "field": "email",
      "message": "must be a well-formed email address"
    }
  ]
}
```

## Search behavior

- The `lastName` query parameter is required and must be non-blank.
- The search is case-insensitive and matches substrings.
- When no records match, the response is `200 OK` with an empty list.
