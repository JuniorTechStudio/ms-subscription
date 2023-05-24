package com.jts.subscription.subscription.facade;

import com.jts.subscription.subscription.client.ContentClient;
import com.jts.subscription.subscription.data.entity.SubscriptionTitle;
import com.jts.subscription.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final ContentClient contentClient;
    private final SubscriptionService subscriptionService;

    public void createAndSendPrepareAndSendContentRequest(SubscriptionTitle title) {
        var subscriptionUserInfoList = subscriptionService.findSubscriptionUserInfo(title);
        var preparedContent = subscriptionService.createPrepareAndSendContentRequest(subscriptionUserInfoList);
        contentClient.sendWord(preparedContent);
    }

}
