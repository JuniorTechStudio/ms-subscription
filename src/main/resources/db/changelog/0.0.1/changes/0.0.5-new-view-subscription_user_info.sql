--liquibase formatted sql
--changeset BichikArtem:5

CREATE VIEW subscription.subscription_user_info_view
    AS SELECT u.telegram_id,  s.title,  u.order_number
    FROM  subscription.subscription s, subscription.subscription_user_info u
    WHERE s.id = u.subscription_id;