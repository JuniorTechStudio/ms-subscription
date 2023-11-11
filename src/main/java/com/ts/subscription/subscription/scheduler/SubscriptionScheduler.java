package com.ts.subscription.subscription.scheduler;

import com.ts.subscription.subscription.facade.SubscriptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionScheduler {

  private final SubscriptionFacade subscriptionFacade;

//  @Scheduled(fixedDelayString = "${schedule.prepare.content:300_000}", zone = "Europe/Moscow")
  @Scheduled(cron = "0 0 13 * * *", zone = "Europe/Moscow")
  public void prepareContent() {
    subscriptionFacade.prepareAndSendContent();
  }

}
