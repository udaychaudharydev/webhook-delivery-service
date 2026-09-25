--liquibase formatted sql

--changeset uday:001-create-events
CREATE TABLE events (
    id UUID PRIMARY KEY,
    event_type TEXT NOT NULL,
    payload JSONB NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

--rollback DROP TABLE events;