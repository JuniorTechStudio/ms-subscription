package com.jts.subscription.subscription.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionUserInfoDTO {
    private String telegramId;
    private UUID subscriptionId;
    private Integer order;
}
