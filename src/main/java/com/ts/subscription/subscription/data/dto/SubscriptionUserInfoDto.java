package com.ts.subscription.subscription.data.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionUserInfoDto {

    private String telegramId;
    private UUID subscriptionId;
    private String subscriptionTitle;
    private Integer order;

}
