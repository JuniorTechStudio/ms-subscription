--liquibase formatted sql
--changeset BichikArtem:1

CREATE TABLE IF NOT EXISTS subscription.schedule_of_content_sending
(
    id                  bigint constraint schedule_pkey primary key default (nextval('subscription_sequence')),
    subscription_id     uuid,
    time                timestamp with time zone,
    CONSTRAINT subscription_fk FOREIGN KEY (subscription_id) REFERENCES subscription.subscription(id)
);