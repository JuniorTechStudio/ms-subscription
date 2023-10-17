--liquibase formatted sql
--changeset BichikArtem:1

CREATE SCHEMA IF NOT EXISTS subscription;

CREATE TABLE IF NOT EXISTS subscription.subscription
(
    id uuid constraint subscription_pkey primary key,
    title varchar
);

CREATE TABLE IF NOT EXISTS subscription.subscription_user_info
(
    user_id uuid not null,
    telegram_id varchar,
    subscription_id uuid,
    subscription_title varchar ,
    order_number int,
    CONSTRAINT subscription_fk FOREIGN KEY (subscription_id) REFERENCES subscription.subscription(id)
);
