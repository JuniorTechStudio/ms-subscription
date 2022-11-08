--liquibase formatted sql

--changeset Pavlik:1
CREATE SCHEMA IF NOT EXISTS subscription;
CREATE TABLE IF NOT EXISTS subscription.subscription
(
    id        uuid not null
    constraint subscription_pkey primary key,
    title varchar
);