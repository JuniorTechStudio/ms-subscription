package com.ts.subscription.subscription.controller;

import com.ts.subscription.subscription.data.dto.*;
import com.ts.subscription.subscription.scheduler.SubscriptionScheduler;
import com.ts.subscription.subscription.service.SubscriptionService;
import java.util.UUID;

import com.ts.subscription.subscription.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final UserInfoService userInfoService;
    private final SubscriptionScheduler subscriptionScheduler;

    @GetMapping
    public ResponseEntity<SubscriptionsList> getAllSubscriptions() {
        var subscriptionsList = subscriptionService.getAllSubscriptionInfo();
        return ResponseEntity.ok(subscriptionsList);
    }

    @GetMapping("/{subscriptionId}")
    public ResponseEntity<SubscriptionValue> getSubscriptionById(@PathVariable UUID subscriptionId) {
        var subscriptionValue = subscriptionService.getSubscriptionById(subscriptionId);
        return ResponseEntity.ok(subscriptionValue);
    }

    @PostMapping
    public ResponseEntity<SubscriptionCreateResponse> createSubscription(@RequestBody SubscriptionCreateRequest request) {
        var savedSubscription = subscriptionService.saveSubscription(request);
        return ResponseEntity.ok(savedSubscription);
    }

    @PatchMapping("/{subscriptionId}")
    public ResponseEntity<SubscriptionUpdateResponse> updateSubscription(
            @PathVariable UUID subscriptionId,
            @RequestBody SubscriptionUpdateRequest request
    ) {
        var updatedSubscription = subscriptionService.updateSubscription(subscriptionId, request);
        return ResponseEntity.ok(updatedSubscription);
    }

    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable UUID subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{subscriptionId}/users")
    public ResponseEntity<Void> subscribe(
            @PathVariable UUID subscriptionId,
            @RequestBody AddUserToSubscriptionRequest request
    ) {
        userInfoService.subscribe(subscriptionId, request);
        return ResponseEntity.ok().build();
    }

  @PostMapping("/{subscriptionId}/users/{telegramId}")
  public ResponseEntity<Void> incrementOrderNumber(
          @PathVariable UUID subscriptionId,
          @PathVariable String telegramId
  ) {
        userInfoService.incrementOrderNumber(subscriptionId, telegramId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/test")
    public ResponseEntity<Void> testScheduler() {
        subscriptionScheduler.prepareContent();
        return ResponseEntity.ok().build();
    }
    
}
