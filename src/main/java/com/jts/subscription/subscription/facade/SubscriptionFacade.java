package com.jts.subscription.subscription.facade;

import com.jts.subscription.subscription.client.ContentClient;
import com.jts.subscription.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final ContentClient contentClient;
    private final SubscriptionService subscriptionService;

    public void createAndSendPrepareAndSendContentRequest(String title) {
        var subscriptionUserInfoList = subscriptionService.findSubscriptionUserInfoAndIncrementOrder(title);
        var prepareAndSendContentRequest = subscriptionService.createPrepareAndSendContentRequest(subscriptionUserInfoList);
        contentClient.prepareAndSendContent(prepareAndSendContentRequest);
    }

}
