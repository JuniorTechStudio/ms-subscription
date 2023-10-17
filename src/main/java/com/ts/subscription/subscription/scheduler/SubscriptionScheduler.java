package com.ts.subscription.subscription.scheduler;

import com.ts.subscription.subscription.facade.SubscriptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionScheduler {

  private final SubscriptionFacade subscriptionFacade;

//  @Scheduled(cron = "0 0 11 * * *", zone = "Europe/Moscow")
  public void prepareJavaContent() {
    subscriptionFacade.prepareAndSendContent("JAVA");
  }

  //    @Scheduled(cron = "0 0 12 * * *", zone = "Europe/Moscow")
  public void prepareSQLContent() {
    subscriptionFacade.prepareAndSendContent("SQL");
  }

  @Schedules({
//    @Scheduled(cron = "0 0 10 * * *", zone = "Europe/Moscow"),
    @Scheduled(cron = "0 0 13 * * *", zone = "Europe/Moscow")
//    @Scheduled(cron = "0 0 16 * * *", zone = "Europe/Moscow"),
//    @Scheduled(cron = "0 0 19 * * *", zone = "Europe/Moscow"),
//    @Scheduled(cron = "0 0 20 * * *", zone = "Europe/Moscow"),
//    @Scheduled(cron = "0 0 22 * * *", zone = "Europe/Moscow")
  })
  public void prepareEnglishContent() {
    subscriptionFacade.prepareAndSendContent("ENGLISH");
  }

}
