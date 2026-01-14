# Data Model: Person Records Service

## Entity: Person

**Purpose**: Represents an individual managed by the service.

**Fields**:
- **id**: Unique identifier assigned by the system.
- **firstName**: Person's given name.
- **lastName**: Person's family name.
- **email**: Contact email address.

**Validation Rules**:
- firstName is required and must be non-empty.
- lastName is required and must be non-empty.
- email is required, must be non-empty, and must follow a standard email format.

**Relationships**: None.

**State Transitions**:
- Created → Updated → Deleted (record lifecycle only).
