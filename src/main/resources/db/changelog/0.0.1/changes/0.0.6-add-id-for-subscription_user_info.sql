--liquibase formatted sql
--changeset BichikArtem:6

ALTER TABLE subscription.subscription_user_info
    ADD COLUMN id bigint default (nextval('subscription_sequence'));