package com.jts.subscription.subscription.service;

import com.jts.subscription.subscription.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.subscription.data.dto.SaveSubscriptionUserInfoRequest;
import com.jts.subscription.subscription.data.entity.SubscriptionTitle;
import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import com.jts.subscription.subscription.data.mapper.SubscriptionUserInfoMapper;
import com.jts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

  private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;
  private final SubscriptionUserInfoMapper subscriptionUserInfoMapper;

  public PrepareAndSendContentRequest createPrepareAndSendContentRequest(
      List<SubscriptionUserInfo> subscriptionUserInfoList) {
    return PrepareAndSendContentRequest.builder()
        .subscriptionUserInfoDTOList(
            subscriptionUserInfoMapper.mapToSubscriptionUserInfoDTO(subscriptionUserInfoList))
        .build();
  }

  public List<SubscriptionUserInfo> findSubscriptionUserInfo(SubscriptionTitle title) {
    return subscriptionUserInfoRepository.findAllBySubscriptionTitle(title);
  }

  public void saveSubscriptionUserInfo(SaveSubscriptionUserInfoRequest request) {
    var subscriptionUserInfo = subscriptionUserInfoMapper.mapToSubscriptionUserInfo(request);
    subscriptionUserInfoRepository.save(subscriptionUserInfo);
  }

}