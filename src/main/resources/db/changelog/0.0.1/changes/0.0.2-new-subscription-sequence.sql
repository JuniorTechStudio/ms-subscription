--liquibase formatted sql
--changeset BichikArtem:1

CREATE SEQUENCE IF NOT EXISTS subscription_sequence
    START WITH 1
    INCREMENT BY 1;