package com.jts.subscription.subscription.controller;

import com.jts.subscription.subscription.data.dto.SaveSubscriptionUserInfoRequest;
import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveSubscriptionUserInfo(@RequestBody SaveSubscriptionUserInfoRequest request) {
        subscriptionService.saveSubscriptionUserInfo(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/complete")
    public void completeSubscription(@RequestBody List<SubscriptionUserInfoDTO> completedSubscriptionList) {
        subscriptionService.completeSubscription(completedSubscriptionList);
    }

}
