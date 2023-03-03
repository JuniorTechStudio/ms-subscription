--liquibase formatted sql

--changeset Pavlik:5
ALTER TABLE subscription.subscription_user_info
    ADD COLUMN subscription_id uuid;
ALTER TABLE subscription.subscription_user_info
    ADD CONSTRAINT unique_name UNIQUE (user_id, subscription_title);