package com.ts.subscription.subscription.service;

import com.ts.subscription.subscription.data.dto.AddUserToSubscriptionRequest;
import com.ts.subscription.subscription.data.entity.SubscriptionUserInfo;
import com.ts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;

    public void subscribe(UUID subscriptionId, AddUserToSubscriptionRequest request) {
        var newSubscriptionUserInfo = new SubscriptionUserInfo()
                .setUserId(UUID.randomUUID())
                .setSubscriptionTitle(null)
                .setTelegramId(request.telegramId())
                .setSubscriptionId(subscriptionId)
                .setOrderNumber(0);
        subscriptionUserInfoRepository.save(newSubscriptionUserInfo);
    }

}
