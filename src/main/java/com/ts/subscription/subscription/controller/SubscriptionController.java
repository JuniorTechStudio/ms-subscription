package com.ts.subscription.subscription.controller;

import com.ts.subscription.subscription.data.dto.SaveSubscriptionUserInfoRequest;
import com.ts.subscription.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping
    public ResponseEntity<List<Object>> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptionInfo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getSubscriptionById(@PathVariable String id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> saveSubscriptionUserInfo(@RequestBody SaveSubscriptionUserInfoRequest request) {
        subscriptionService.saveSubscriptionUserInfo(request);
        return ResponseEntity.ok().build();
    }

}
