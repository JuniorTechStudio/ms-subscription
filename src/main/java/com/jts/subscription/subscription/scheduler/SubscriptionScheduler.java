package com.jts.subscription.subscription.scheduler;

import com.jts.subscription.subscription.facade.SubscriptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionScheduler {

    private final SubscriptionFacade subscriptionFacade;

    @Scheduled(cron = "0 0 11 * * *", zone = "Europe/Moscow")
    public void prepareJavaContent() {
        subscriptionFacade.prepareAndSendSubscriptionUserInfoRequest("Java");
    }

//    @Scheduled(cron = "0 0 12 * * *", zone = "Europe/Moscow")
    public void prepareSQLContent() {
        subscriptionFacade.prepareAndSendSubscriptionUserInfoRequest("SQL");
    }

//    @Scheduled(cron = "0 0 13 * * *", zone = "Europe/Moscow")
    public void prepareEnglishContent() {
        subscriptionFacade.prepareAndSendSubscriptionUserInfoRequest("English");
    }

}
