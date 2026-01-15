# Phase 0 Research: Person Last Name Search

## Decisions

### Decision: Java 25 with Spring Boot 4.x (Maven)
- **Rationale**: Matches the existing service stack and avoids introducing new tooling for a small feature.
- **Alternatives considered**: Java 21 LTS, Gradle build.

### Decision: Spring Web for REST endpoint
- **Rationale**: Existing controller layer already uses Spring Web patterns.
- **Alternatives considered**: JAX-RS standalone stack.

### Decision: Spring Data JDBC for search persistence
- **Rationale**: Keeps the persistence approach consistent with existing CRUD operations.
- **Alternatives considered**: Manual JDBC queries.

### Decision: H2 in-memory database for local execution
- **Rationale**: Aligned with the current environment and repeatable tests.
- **Alternatives considered**: PostgreSQL, SQLite.

### Decision: Jakarta Validation for query validation
- **Rationale**: Standard declarative validation for missing/blank query parameters.
- **Alternatives considered**: Manual validation logic.
