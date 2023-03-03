package com.jts.subscription.subscription.service;

import com.jts.subscription.subscription.data.dto.SaveSubscriptionUserInfoRequest;
import com.jts.subscription.subscription.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import com.jts.subscription.subscription.data.mapper.SubscriptionUserInfoMapper;
import com.jts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;
    private final SubscriptionUserInfoMapper subscriptionUserInfoMapper;

    public PrepareAndSendContentRequest createPrepareAndSendContentRequest(List<SubscriptionUserInfo> subscriptionUserInfoList) {
        return PrepareAndSendContentRequest
                .builder()
                .subscriptionUserInfoDTOList(subscriptionUserInfoMapper.mapToSubscriptionUserInfoDTO(subscriptionUserInfoList))
                .build();
    }

    @Transactional
    public List<SubscriptionUserInfo> findSubscriptionUserInfoAndIncrementOrder(String title) {
        var subscriptionUserInfoList = subscriptionUserInfoRepository.findAllBySubscriptionTitle(title);
        subscriptionUserInfoList.forEach(SubscriptionUserInfo::incrementOrder);
        return subscriptionUserInfoList;
    }

    public void saveSubscriptionUserInfo(SaveSubscriptionUserInfoRequest request) {
        subscriptionUserInfoRepository
                .save(subscriptionUserInfoMapper.mapToSubscriptionUserInfo(request));
    }

    public void completeSubscription(List<SubscriptionUserInfoDTO> completedSubscriptionList) {
        for (SubscriptionUserInfoDTO subscriptionUserInfoDTO : completedSubscriptionList) {
            String id = subscriptionUserInfoDTO.getTelegramId();
            String title = subscriptionUserInfoDTO.getSubscriptionTitle();

            subscriptionUserInfoRepository.deleteByTelegramIdAndSubscriptionTitle(id, title);
        }
    }

}
