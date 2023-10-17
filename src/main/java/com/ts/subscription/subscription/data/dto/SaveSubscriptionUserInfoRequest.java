package com.ts.subscription.subscription.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveSubscriptionUserInfoRequest {

    private UUID userId;
    private String telegramId;
    private UUID subscriptionId;
    private String subscriptionTitle;
    private int order;

}