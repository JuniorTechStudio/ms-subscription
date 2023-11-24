package com.ts.subscription.subscription.data.mapper;

import com.ts.subscription.subscription.data.dto.*;
import com.ts.subscription.subscription.data.entity.Subscription;
import com.ts.subscription.subscription.data.entity.SubscriptionUserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionValue toSubscriptionValue(Subscription subscription);

    SubscriptionCreateResponse toSubscriptionCreateResponse(Subscription subscription);

    List<SubscriptionValue> toSubscriptionValueList(List<Subscription> subscriptionList);

    SubscriptionUpdateResponse toSubscriptionUpdateResponse(Subscription subscription);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderNumber", ignore = true)
    SubscriptionUserInfo mapToSubscriptionUserInfo(SaveSubscriptionUserInfoRequest subscriptionUserInfoRequest);

    default SubscriptionsList toSubscriptionsList(List<Subscription> subscriptionList) {
        List<SubscriptionValue> subscriptionValueList = toSubscriptionValueList(subscriptionList);
        return new SubscriptionsList(subscriptionValueList);
    }
}
