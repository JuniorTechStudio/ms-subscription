package com.ts.subscription.subscription.facade;

import com.ts.subscription.subscription.client.TelegramAdapterClient;
import com.ts.subscription.subscription.data.dto.TelegramSendContentRequest;
import com.ts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import com.ts.subscription.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final SubscriptionService subscriptionService;
    private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;
    private final TelegramAdapterClient telegramAdapterClient;

    public void prepareAndSendContent(String title) {
        var subscriptionUserInfoList = subscriptionUserInfoRepository.findAllBySubscriptionTitle(title);
        List<TelegramSendContentRequest> requestList = subscriptionService.prepareContentForSending(subscriptionUserInfoList);
        telegramAdapterClient.sendContent(requestList);
    }

}
