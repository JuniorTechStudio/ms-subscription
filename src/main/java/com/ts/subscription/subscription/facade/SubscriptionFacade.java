package com.ts.subscription.subscription.facade;

import com.ts.subscription.subscription.client.ContentClient;
import com.ts.subscription.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final ContentClient contentClient;
    private final SubscriptionService subscriptionService;

    public void prepareAndSendContent(String title) {
        var sendContentRequest = subscriptionService.createSendContentRequest(title);
        contentClient.sendContent(sendContentRequest);
    }

}
