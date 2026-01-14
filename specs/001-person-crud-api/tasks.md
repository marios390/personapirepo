---

description: "Task list for Person Records Service"
---

# Tasks: Person Records Service

**Input**: Design documents from `/specs/001-person-crud-api/`
**Prerequisites**: plan.md (required), spec.md (required for user stories), research.md, data-model.md, contracts/

**Tests**: Not requested in the feature specification.

**Organization**: Tasks are grouped by user story to enable independent implementation and testing of each story.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: Which user story this task belongs to (e.g., US1, US2, US3)
- Include exact file paths in descriptions

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Project initialization and basic structure

- [X] T001 Create Maven project structure and base packages under `/home/marios390/person-api/src/main/java/com/example/personapi/` and `/home/marios390/person-api/src/test/java/com/example/personapi/`
- [X] T002 Initialize `/home/marios390/person-api/pom.xml` with Spring Boot 4.x, Spring Web, Spring Data JDBC, Jakarta Validation, H2, and Spring Boot Test dependencies
- [X] T003 [P] Add Spring Boot entrypoint in `/home/marios390/person-api/src/main/java/com/example/personapi/PersonApiApplication.java`
- [X] T004 [P] Add base configuration in `/home/marios390/person-api/src/main/resources/application.yml` (server port, H2 datasource, JDBC init)

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Core infrastructure that MUST be complete before ANY user story can be implemented

**⚠️ CRITICAL**: No user story work can begin until this phase is complete

- [X] T005 Define database schema in `/home/marios390/person-api/src/main/resources/schema.sql` for the person table
- [X] T006 [P] Create Person record and mapping annotations in `/home/marios390/person-api/src/main/java/com/example/personapi/model/Person.java`
- [X] T007 [P] Create request/response DTOs with validation annotations in `/home/marios390/person-api/src/main/java/com/example/personapi/dto/PersonCreateRequest.java`, `/home/marios390/person-api/src/main/java/com/example/personapi/dto/PersonUpdateRequest.java`, `/home/marios390/person-api/src/main/java/com/example/personapi/dto/PersonResponse.java`
- [X] T008 [P] Create repository interface in `/home/marios390/person-api/src/main/java/com/example/personapi/repository/PersonRepository.java`
- [X] T009 Create service shell with list/get/create/update/delete method signatures in `/home/marios390/person-api/src/main/java/com/example/personapi/service/PersonService.java`
- [X] T010 [P] Add not-found exception in `/home/marios390/person-api/src/main/java/com/example/personapi/exception/PersonNotFoundException.java`
- [X] T011 [P] Add error response models in `/home/marios390/person-api/src/main/java/com/example/personapi/exception/ErrorResponse.java`, `/home/marios390/person-api/src/main/java/com/example/personapi/exception/FieldErrorItem.java`, `/home/marios390/person-api/src/main/java/com/example/personapi/exception/ValidationErrorResponse.java`
- [X] T012 Add global exception handler to map validation and not-found errors in `/home/marios390/person-api/src/main/java/com/example/personapi/exception/GlobalExceptionHandler.java`
- [X] T013 Create controller shell in `/home/marios390/person-api/src/main/java/com/example/personapi/controller/PersonController.java` with base routing

**Checkpoint**: Foundation ready - user story implementation can now begin in parallel

---

## Phase 3: User Story 1 - Browse People Directory (Priority: P1) 🎯 MVP

**Goal**: List all people and retrieve a person by identifier.

**Independent Test**: Seed at least one record, call list endpoint to verify it appears, then call get-by-id to verify details.

### Implementation for User Story 1

- [X] T014 [US1] Implement list logic in `/home/marios390/person-api/src/main/java/com/example/personapi/service/PersonService.java`
- [X] T015 [US1] Implement get-by-id logic with not-found handling in `/home/marios390/person-api/src/main/java/com/example/personapi/service/PersonService.java`
- [X] T016 [US1] Implement GET endpoints in `/home/marios390/person-api/src/main/java/com/example/personapi/controller/PersonController.java`

**Checkpoint**: User Story 1 should be fully functional and testable independently

---

## Phase 4: User Story 2 - Create Person Record (Priority: P2)

**Goal**: Create a person record with validation and return the created record.

**Independent Test**: Submit a valid create request and verify the record appears in list/get; submit invalid data and verify field errors.

### Implementation for User Story 2

- [X] T017 [US2] Implement create logic in `/home/marios390/person-api/src/main/java/com/example/personapi/service/PersonService.java`
- [X] T018 [US2] Implement POST endpoint with validation in `/home/marios390/person-api/src/main/java/com/example/personapi/controller/PersonController.java`

**Checkpoint**: User Stories 1 and 2 should both work independently

---

## Phase 5: User Story 3 - Maintain Person Records (Priority: P3)

**Goal**: Update and delete existing person records.

**Independent Test**: Update a record and confirm changes via get; delete a record and confirm it no longer appears.

### Implementation for User Story 3

- [X] T019 [US3] Implement update logic with full replacement in `/home/marios390/person-api/src/main/java/com/example/personapi/service/PersonService.java`
- [X] T020 [US3] Implement delete logic in `/home/marios390/person-api/src/main/java/com/example/personapi/service/PersonService.java`
- [X] T021 [US3] Implement PUT and DELETE endpoints in `/home/marios390/person-api/src/main/java/com/example/personapi/controller/PersonController.java`

**Checkpoint**: All user stories should now be independently functional

---

## Phase 6: Polish & Cross-Cutting Concerns

**Purpose**: Improvements that affect multiple user stories

- [X] T022 [P] Validate quickstart steps and update `/home/marios390/person-api/specs/001-person-crud-api/quickstart.md` if adjustments are needed
- [X] T023 [P] Document API usage and error format in `/home/marios390/person-api/README.md`

---

## Dependencies & Execution Order

### Phase Dependencies

- **Setup (Phase 1)**: No dependencies - can start immediately
- **Foundational (Phase 2)**: Depends on Setup completion - BLOCKS all user stories
- **User Stories (Phase 3+)**: All depend on Foundational phase completion
- **Polish (Phase 6)**: Depends on all desired user stories being complete

### User Story Dependencies

- **User Story 1 (P1)**: Can start after Foundational (Phase 2) - No dependencies on other stories
- **User Story 2 (P2)**: Can start after Foundational (Phase 2) - Builds on shared service/controller files
- **User Story 3 (P3)**: Can start after Foundational (Phase 2) - Builds on shared service/controller files

### User Story Completion Order (Dependency Graph)

Setup → Foundational → US1 → US2 → US3 → Polish

### Parallel Opportunities

- Setup: T003 and T004 can run in parallel after T002
- Foundational: T006, T007, T008, T010, T011 can run in parallel
- User stories: US1, US2, US3 are sequential due to shared service/controller files

---

## Parallel Example: User Story 1

No parallel tasks within US1 because tasks update shared files (`PersonService.java`, `PersonController.java`).

---

## Parallel Example: User Story 2

No parallel tasks within US2 because tasks update shared files (`PersonService.java`, `PersonController.java`).

---

## Parallel Example: User Story 3

No parallel tasks within US3 because tasks update shared files (`PersonService.java`, `PersonController.java`).

---

## Implementation Strategy

### MVP First (User Story 1 Only)

1. Complete Phase 1: Setup
2. Complete Phase 2: Foundational (CRITICAL - blocks all stories)
3. Complete Phase 3: User Story 1
4. **STOP and VALIDATE**: Test User Story 1 independently
5. Deploy/demo if ready

### Incremental Delivery

1. Complete Setup + Foundational → Foundation ready
2. Add User Story 1 → Test independently → Deploy/Demo (MVP)
3. Add User Story 2 → Test independently → Deploy/Demo
4. Add User Story 3 → Test independently → Deploy/Demo
5. Each story adds value without breaking previous stories

---

## Notes

- [P] tasks = different files, no dependencies
- [Story] label maps task to specific user story for traceability
- Each user story should be independently completable and testable
- Avoid: vague tasks, same file conflicts, cross-story dependencies that break independence
