package com.ts.subscription.subscription.service;

import com.ts.subscription.subscription.client.ContentClient;
import com.ts.subscription.subscription.data.dto.*;
import com.ts.subscription.subscription.data.entity.Subscription;
import com.ts.subscription.subscription.data.entity.SubscriptionUserInfo;
import com.ts.subscription.subscription.data.mapper.SubscriptionMapper;
import com.ts.subscription.subscription.error.SubscriptionNotFound;
import com.ts.subscription.subscription.repository.SubscriptionRepository;
import com.ts.subscription.subscription.repository.SubscriptionUserInfoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

  private final SubscriptionRepository subscriptionRepository;
  private final SubscriptionMapper subscriptionMapper;
  private final ContentClient contentClient;


  public SubscriptionsList getAllSubscriptionInfo() {
    var allSubscriptions = subscriptionRepository.findAll();
    return subscriptionMapper.toSubscriptionsList(allSubscriptions);
  }

  public SubscriptionValue getSubscriptionById(UUID subscriptionId) {
    var subscription = getById(subscriptionId);
    return subscriptionMapper.toSubscriptionValue(subscription);
  }

  public SubscriptionValue saveSubscription(SubscriptionCreateRequest request) {
    var newSubscription = new Subscription().setTitle(request.title());
    var savedSubscription = subscriptionRepository.save(newSubscription);
    return subscriptionMapper.toSubscriptionValue(savedSubscription);
  }

  public SubscriptionUpdateResponse updateSubscription(UUID subscriptionId, SubscriptionUpdateRequest request) {
    Subscription subscription = getById(subscriptionId);
    subscription.setTitle(request.title());
    subscriptionRepository.save(subscription);
    return subscriptionMapper.toSubscriptionUpdateResponse(subscription);
  }

  public void deleteSubscription(UUID subscriptionId) {
    subscriptionRepository.deleteById(subscriptionId);
  }

  public List<TelegramSendContentRequest> prepareContentForSending(List<SubscriptionUserInfo> subscriptionUserInfoList) {
    List<TelegramSendContentRequest> requestList = new ArrayList<>();
    subscriptionUserInfoList.forEach(userInfo -> {
      UUID subscriptionId = userInfo.getSubscriptionId();
      int orderNumber = userInfo.getOrderNumber();
      try {
        String content = contentClient.getContentByOrderNumber(subscriptionId, orderNumber);
        requestList.add(new TelegramSendContentRequest(userInfo.getTelegramId(), content));
      } catch (Exception e) {
        log.error(format("Can not get content by subscriptionId[%s] and orderNumber[%s]", subscriptionId, orderNumber));
      }
    });
    return requestList;
  }

  public Subscription getById(UUID subscriptionId) {
    return subscriptionRepository.findById(subscriptionId).orElseThrow(
            () -> new SubscriptionNotFound(subscriptionId,
            format("Subscription with id[%s] not found", subscriptionId)));
  }
}