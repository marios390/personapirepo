---

description: "Task list for Person Last Name Search"
---

# Tasks: Person Last Name Search

**Input**: Design documents from `/specs/001-person-lastname-search/`
**Prerequisites**: plan.md (required), spec.md (required for user stories), research.md, data-model.md, contracts/

**Tests**: Not requested in the feature specification.

**Organization**: Tasks are grouped by user story to enable independent implementation and testing of each story.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: Which user story this task belongs to (e.g., US1, US2, US3)
- Include exact file paths in descriptions

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Project initialization and basic structure

- [X] T001 Verify dependencies already include validation and data JDBC in `/home/marios390/person-api/pom.xml`
- [X] T002 [P] Confirm schema supports last_name column in `/home/marios390/person-api/src/main/resources/schema.sql`

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Core infrastructure that MUST be complete before ANY user story can be implemented

**⚠️ CRITICAL**: No user story work can begin until this phase is complete

- [X] T003 Add repository search method for last name substring in `/home/marios390/person-api/src/main/java/com/example/personapi/repository/PersonRepository.java`
- [X] T004 Add search service method to map results to responses in `/home/marios390/person-api/src/main/java/com/example/personapi/service/PersonService.java`
- [X] T005 Add query validation DTO (if needed) or validation helper in `/home/marios390/person-api/src/main/java/com/example/personapi/dto/PersonSearchRequest.java`

**Checkpoint**: Foundation ready - user story implementation can now begin

---

## Phase 3: User Story 1 - Find People by Last Name (Priority: P1) 🎯 MVP

**Goal**: Search people by last name and return matches or an empty result.

**Independent Test**: Create multiple people with varying last names, call `/persons/search?lastName=<query>` and verify only matching records are returned; verify empty list when no matches; verify validation error on blank query.

### Implementation for User Story 1

- [X] T006 [US1] Add GET `/persons/search` endpoint with query validation in `/home/marios390/person-api/src/main/java/com/example/personapi/controller/PersonController.java`
- [X] T007 [US1] Implement case-insensitive substring query in `/home/marios390/person-api/src/main/java/com/example/personapi/service/PersonService.java`
- [X] T008 [US1] Ensure validation errors for missing/blank lastName return proper response in `/home/marios390/person-api/src/main/java/com/example/personapi/exception/GlobalExceptionHandler.java`
- [X] T009 [US1] Update API contract for search endpoint in `/home/marios390/person-api/specs/001-person-lastname-search/contracts/openapi.yaml`

**Checkpoint**: User Story 1 should be fully functional and testable independently

---

## Phase 4: Polish & Cross-Cutting Concerns

**Purpose**: Improvements that affect multiple user stories

- [X] T010 [P] Update quickstart examples in `/home/marios390/person-api/specs/001-person-lastname-search/quickstart.md`
- [X] T011 [P] Document search behavior and empty-result status in `/home/marios390/person-api/README.md`

---

## Dependencies & Execution Order

### Phase Dependencies

- **Setup (Phase 1)**: No dependencies - can start immediately
- **Foundational (Phase 2)**: Depends on Setup completion - BLOCKS all user stories
- **User Stories (Phase 3+)**: Depend on Foundational phase completion
- **Polish (Phase 4)**: Depends on User Story 1 completion

### User Story Dependencies

- **User Story 1 (P1)**: Can start after Foundational (Phase 2) - No dependencies on other stories

### User Story Completion Order (Dependency Graph)

Setup → Foundational → US1 → Polish

### Parallel Opportunities

- Setup: T002 can run in parallel after T001
- Polish: T010 and T011 can run in parallel

---

## Parallel Example: User Story 1

No parallel tasks within US1 because tasks update shared files (`PersonService.java`, `PersonController.java`, `GlobalExceptionHandler.java`).

---

## Implementation Strategy

### MVP First (User Story 1 Only)

1. Complete Phase 1: Setup
2. Complete Phase 2: Foundational
3. Complete Phase 3: User Story 1
4. **STOP and VALIDATE**: Test User Story 1 independently
5. Deploy/demo if ready

### Incremental Delivery

1. Complete Setup + Foundational → Foundation ready
2. Add User Story 1 → Test independently → Deploy/Demo
3. Apply Polish updates

---

## Notes

- [P] tasks = different files, no dependencies
- [Story] label maps task to specific user story for traceability
- Each user story should be independently completable and testable
- Avoid: vague tasks, same file conflicts, cross-story dependencies that break independence
