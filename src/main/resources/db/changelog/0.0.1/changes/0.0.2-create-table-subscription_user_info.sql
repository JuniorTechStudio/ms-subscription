--liquibase formatted sql

--changeset Pavlik:2
CREATE TABLE IF NOT EXISTS subscription.subscription_user_info
(
    user_id uuid not null
    constraint subscription_user_info_pkey primary key,
    telegram_id varchar,
    subscription_id varchar,
    order_number int
)