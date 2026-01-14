# Quickstart: Person Last Name Search

## Prerequisites

- Service running locally on `http://localhost:8080`

## Example request

Search by last name substring:

```bash
curl "http://localhost:8080/persons/search?lastName=son"
```

Empty result (no matches) returns an empty list with a 200 status.
