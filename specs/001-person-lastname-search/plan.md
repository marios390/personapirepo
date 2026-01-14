# Implementation Plan: Person Last Name Search

**Branch**: `001-person-lastname-search` | **Date**: 2026-01-01 | **Spec**: /home/marios390/person-api/specs/001-person-lastname-search/spec.md
**Input**: Feature specification from `/specs/001-person-lastname-search/spec.md`

**Note**: This template is filled in by the `/speckit.plan` command. See `.specify/templates/commands/plan.md` for the execution workflow.

## Summary

Add a last-name search capability to the person records service, returning all records whose last name contains the query, with validation and explicit empty-result behavior. Implementation will extend the existing Java 25 Spring Boot service using Spring Web and Spring Data JDBC with the current H2 in-memory setup.

## Technical Context

**Language/Version**: Java 25  
**Primary Dependencies**: Spring Boot 4.x, Spring Web, Spring Data JDBC, Jakarta Validation, Maven  
**Storage**: H2 in-memory database  
**Testing**: JUnit 5, Spring Boot Test, MockMvc  
**Target Platform**: Linux server (JVM)  
**Project Type**: single  
**Performance Goals**: 95% of search responses under 1 second in normal business load  
**Constraints**: Validation errors must be field-specific; empty search returns a defined empty result status  
**Scale/Scope**: Single microservice, add search endpoint to Person API

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

- No enforceable principles found in `/home/marios390/person-api/.specify/memory/constitution.md` (template placeholders only).
- Gate status: PASS.
- Post-design check: PASS (no constitution rules to re-evaluate).

## Project Structure

### Documentation (this feature)

```text
specs/001-person-lastname-search/
├── plan.md              # This file (/speckit.plan command output)
├── research.md          # Phase 0 output (/speckit.plan command)
├── data-model.md        # Phase 1 output (/speckit.plan command)
├── quickstart.md        # Phase 1 output (/speckit.plan command)
├── contracts/           # Phase 1 output (/speckit.plan command)
└── tasks.md             # Phase 2 output (/speckit.tasks command - NOT created by /speckit.plan)
```

### Source Code (repository root)

```text
src/
├── main/
│   ├── java/
│   │   └── com/example/personapi/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── exception/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
└── test/
    └── java/
        └── com/example/personapi/
            ├── controller/
            ├── repository/
            └── service/
```

**Structure Decision**: Single Spring Boot service with layered architecture (controller/service/repository/model) under a standard Maven `src/main/java` layout.

## Complexity Tracking

No constitution violations to justify.
