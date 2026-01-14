# Feature Specification: Person Last Name Search

**Feature Branch**: `001-person-lastname-search`  
**Created**: 2026-01-01  
**Status**: Draft  
**Input**: User description: "Add a new feature: search persons by last name. The API should support: - GET /persons/search?lastName={value} - It should return all persons whose lastName contains the search query. - It should handle empty results with appropriate HTTP status."

## User Scenarios & Testing *(mandatory)*

<!--
  IMPORTANT: User stories should be PRIORITIZED as user journeys ordered by importance.
  Each user story/journey must be INDEPENDENTLY TESTABLE - meaning if you implement just ONE of them,
  you should still have a viable MVP (Minimum Viable Product) that delivers value.
  
  Assign priorities (P1, P2, P3, etc.) to each story, where P1 is the most critical.
  Think of each story as a standalone slice of functionality that can be:
  - Developed independently
  - Tested independently
  - Deployed independently
  - Demonstrated to users independently
-->

### User Story 1 - Find People by Last Name (Priority: P1)

As a client application owner, I want to search people by last name so I can quickly find matching records.

**Why this priority**: Search is the core value of this feature and enables users to find records without browsing the full list.

**Independent Test**: Can be fully tested by creating multiple people with varying last names, executing the search with a query, and verifying only matching records are returned.

**Acceptance Scenarios**:

1. **Given** multiple people exist with different last names, **When** the client searches with a query contained in some last names, **Then** the system returns only those matching people.
2. **Given** no person last name contains the query, **When** the client searches, **Then** the system returns an empty response with the specified empty-result status.

---

### Edge Cases
- What happens when the query is empty or only whitespace?
- What happens when the query includes mixed case or special characters?
- How does the system handle unusually long query values?

## Requirements *(mandatory)*

<!--
  ACTION REQUIRED: The content in this section represents placeholders.
  Fill them out with the right functional requirements.
-->

### Functional Requirements

- **FR-001**: System MUST provide a search capability to retrieve people by last name using a query parameter.
- **FR-002**: System MUST return people whose last name contains the search query (case-insensitive matching).
- **FR-003**: System MUST return all matching people, not just the first result.
- **FR-004**: System MUST respond with an appropriate empty-result status when no matches are found.
- **FR-005**: System MUST return a clear validation error when the search query is missing or blank.

### Key Entities *(include if feature involves data)*

- **Person**: Represents an individual with a last name used as the search attribute.

## Assumptions

- Search is limited to the last name field only.
- The search query matches substrings, not whole-word or prefix-only matching.
- The empty-result status is `200 OK` with an empty list unless specified otherwise.

## Success Criteria *(mandatory)*

<!--
  ACTION REQUIRED: Define measurable success criteria.
  These must be technology-agnostic and measurable.
-->

### Measurable Outcomes

- **SC-001**: 95% of search requests return results (including empty results) within 1 second under normal business load.
- **SC-002**: 99% of valid search requests return correct match sets based on last name substring rules.
- **SC-003**: 100% of requests with missing or blank queries return a clear validation error without performing a search.
- **SC-004**: Users can complete a search and view results in under 30 seconds during usability checks.
