package com.jts.subscription.subscription.scheduler;

import com.jts.subscription.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionScheduler {

    private final SubscriptionService subscriptionService;

    @Scheduled(fixedDelay = 10000L)
    public void prepareJavaContent() {
        subscriptionService.prepareContentByTitle("Java");
    }

    @Scheduled(fixedDelay = 10000L)
    public void prepareSQLContent() {
        subscriptionService.prepareContentByTitle("SQL");
    }

    @Scheduled(fixedDelay = 10000L)
    public void prepareEnglishContent() {
        subscriptionService.prepareContentByTitle("English");
    }
}
