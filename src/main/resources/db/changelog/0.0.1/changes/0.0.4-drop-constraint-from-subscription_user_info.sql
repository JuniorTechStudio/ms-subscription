--liquibase formatted sql

--changeset Pavlik:4
alter table subscription.subscription_user_info
drop constraint subscription_user_info_pkey;