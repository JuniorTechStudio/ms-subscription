package com.ts.subscription.subscription.facade;

import com.ts.subscription.subscription.client.TelegramAdapterClient;
import com.ts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import com.ts.subscription.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final SubscriptionService subscriptionService;
    private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;
    private final TelegramAdapterClient telegramAdapterClient;

    public void prepareAndSendContent() {
        var subscriptionUserInfoList = subscriptionUserInfoRepository.findAll();
        var telegramSendContentRequest = subscriptionService.prepareContentForSending(subscriptionUserInfoList);
        telegramAdapterClient.sendContent(telegramSendContentRequest);
    }

}
