package com.ts.subscription.subscription.scheduler;

import com.ts.subscription.subscription.facade.SubscriptionFacade;
import com.ts.subscription.subscription.repository.ScheduleOfContentSendingRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionScheduler {

  private final SubscriptionFacade subscriptionFacade;
  private final ThreadPoolTaskScheduler taskScheduler;
  private final ScheduleOfContentSendingRepository scheduleOfContentSendingRepository;

  @EventListener(ApplicationReadyEvent.class)
  public void prepareSubscriptionSchedulers() {
    log.info("---=== SubscriptionScheduler::prepareSubscriptionSchedulers ===---");
    scheduleOfContentSendingRepository.findAll().forEach(schedule -> {
      UUID subscriptionId = schedule.getSubscriptionId();
      CronTrigger cronTrigger = schedule.getCronTrigger();
      Runnable scheduleTask = () -> subscriptionFacade.prepareAndSendContent(subscriptionId);
      taskScheduler.schedule(scheduleTask, cronTrigger);
    });
  }

}
