# Data Model: Person Last Name Search

## Entity: Person

**Purpose**: Represents an individual whose last name is used for search matching.

**Fields**:
- **id**: Unique identifier assigned by the system.
- **firstName**: Person's given name.
- **lastName**: Person's family name (searchable field).
- **email**: Contact email address.

**Validation Rules**:
- lastName must be non-empty and available for search matching.

**Relationships**: None.

**State Transitions**: None (search-only feature).
