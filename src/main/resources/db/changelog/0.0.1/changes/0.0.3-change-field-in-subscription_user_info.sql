--liquibase formatted sql

--changeset Pavlik:3
ALTER TABLE subscription.subscription_user_info
RENAME COLUMN subscription_id TO subscription_title;