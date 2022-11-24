package com.jts.subscription.subscription.controller;

import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoRequest;
import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import com.jts.subscription.subscription.data.mapper.SubscriptionUserInfoMapper;
import com.jts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;
    private final SubscriptionUserInfoMapper subscriptionUserInfoMapper;

    @PostMapping
    @RequestMapping("/save")
    public void saveSubscriptionUserInfo(@RequestBody SubscriptionUserInfoRequest subscriptionUserInfoRequest) {
        SubscriptionUserInfo subscriptionUserInfo = subscriptionUserInfoMapper.mapToSubscriptionUserInfo(subscriptionUserInfoRequest);
        subscriptionUserInfoRepository.save(subscriptionUserInfo);
    }
}
