package com.ts.subscription.subscription.service;

import com.ts.subscription.subscription.data.dto.SendContentRequest;
import com.ts.subscription.subscription.data.dto.SaveSubscriptionUserInfoRequest;
import com.ts.subscription.subscription.data.mapper.SubscriptionUserInfoMapper;
import com.ts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

  private final SubscriptionUserInfoRepository subscriptionUserInfoRepository;
  private final SubscriptionUserInfoMapper subscriptionUserInfoMapper;

  public ResponseEntity<List<Object>> getAllSubscriptionInfo() {
    return null;
  }

  public SendContentRequest createSendContentRequest(String title) {
    var subscriptionUserInfoList = subscriptionUserInfoRepository.findAllBySubscriptionTitle(title);
    var subscriptionUserInfoDtoList = subscriptionUserInfoMapper.mapToSubscriptionUserInfoDTO(subscriptionUserInfoList);
    return new SendContentRequest(subscriptionUserInfoDtoList);
  }

  public void saveSubscriptionUserInfo(SaveSubscriptionUserInfoRequest request) {
    var subscriptionUserInfo = subscriptionUserInfoMapper.mapToSubscriptionUserInfo(request);
    subscriptionUserInfoRepository.save(subscriptionUserInfo);
  }

}