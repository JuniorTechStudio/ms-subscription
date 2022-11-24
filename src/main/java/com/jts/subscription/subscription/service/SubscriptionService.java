package com.jts.subscription.subscription.service;

import com.jts.subscription.subscription.client.ContentClient;
import com.jts.subscription.subscription.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import com.jts.subscription.subscription.data.mapper.SubscriptionUserInfoMapper;
import com.jts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;
    private final SubscriptionUserInfoMapper subscriptionUserInfoMapper;
    private final ContentClient contentClient;

    public void prepareContentByTitle(String title) {
        List<SubscriptionUserInfoDTO> subscriptionUserInfoDTOList = new ArrayList<>();
        List<SubscriptionUserInfo> subscriptionUserInfoList = subscriptionUserInfoRepository.findAllBySubscriptionTitle(title);
        for (SubscriptionUserInfo subscriptionUserInfo : subscriptionUserInfoList) {
            subscriptionUserInfoDTOList.add(subscriptionUserInfoMapper.mapToSubscriptionUserInfoDTO(subscriptionUserInfo));
        }
        PrepareAndSendContentRequest prepareAndSendContentRequest = new PrepareAndSendContentRequest();
        prepareAndSendContentRequest.setSubscriptionUserInfoDTOList(subscriptionUserInfoDTOList);
        contentClient.PrepareAndSendContentRequest(prepareAndSendContentRequest);
        addOrderToUserByTelegramId(subscriptionUserInfoList);
    }

    public void addOrderToUserByTelegramId(List<SubscriptionUserInfo> subscriptionUserInfoList) {
        for (SubscriptionUserInfo subscriptionUserInfo : subscriptionUserInfoList) {
            subscriptionUserInfo.setOrder(subscriptionUserInfo.getOrder() + 1);
            subscriptionUserInfoRepository.save(subscriptionUserInfo);
        }
    }
}
