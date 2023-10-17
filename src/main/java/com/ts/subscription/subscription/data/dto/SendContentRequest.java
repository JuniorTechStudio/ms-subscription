package com.ts.subscription.subscription.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendContentRequest {

    private List<SubscriptionUserInfoDto> subscriptionUserInfoDtoList;

}
