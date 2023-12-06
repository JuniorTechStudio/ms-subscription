ALTER TABLE subscription.schedule_of_content_sending
    ADD COLUMN cron varchar not null;

ALTER TABLE subscription.schedule_of_content_sending
    DROP COLUMN time;