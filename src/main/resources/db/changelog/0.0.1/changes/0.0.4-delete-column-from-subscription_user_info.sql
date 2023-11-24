--liquibase formatted sql
--changeset BichikArtem:1

ALTER TABLE subscription.subscription_user_info drop column user_id;
ALTER TABLE subscription.subscription_user_info drop column subscription_title;

ALTER TABLE subscription.subscription_user_info ALTER COLUMN telegram_id SET NOT NULL;
ALTER TABLE subscription.subscription_user_info ALTER COLUMN order_number SET NOT NULL;