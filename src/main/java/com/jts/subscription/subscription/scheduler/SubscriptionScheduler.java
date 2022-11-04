package com.jts.subscription.subscription.scheduler;

import com.jts.subscription.subscription.client.ContentClient;
import com.jts.subscription.subscription.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import com.jts.subscription.subscription.data.mapper.SubscriptionUserInfoMapper;
import com.jts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionScheduler {

    private final ContentClient contentClient;
    private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;
    private final SubscriptionUserInfoMapper subscriptionUserInfoMapper;

    @Scheduled(fixedDelay = 10000L)
    public void prepareContent() {
        List<SubscriptionUserInfoDTO> subscriptionUserInfoDTOList = new ArrayList<>();
        List<SubscriptionUserInfo> subscriptionUserInfoList = subscriptionUserInfoRepository.findAll();
        for(SubscriptionUserInfo userInfo : subscriptionUserInfoList) {
            subscriptionUserInfoDTOList.add(subscriptionUserInfoMapper.mapToSubscriptionUserInfoDTO(userInfo));
        }
        PrepareAndSendContentRequest prepareAndSendContentRequest = new PrepareAndSendContentRequest();
        prepareAndSendContentRequest.setSubscriptionUserInfoDTOList(subscriptionUserInfoDTOList);
        contentClient.PrepareAndSendContentRequest(prepareAndSendContentRequest);
    }
}
