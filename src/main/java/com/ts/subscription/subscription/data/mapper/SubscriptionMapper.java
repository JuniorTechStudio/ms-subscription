package com.ts.subscription.subscription.data.mapper;

import com.ts.subscription.subscription.data.dto.SaveSubscriptionUserInfoRequest;
import com.ts.subscription.subscription.data.dto.SubscriptionUpdateResponse;
import com.ts.subscription.subscription.data.dto.SubscriptionValue;
import com.ts.subscription.subscription.data.dto.SubscriptionsList;
import com.ts.subscription.subscription.data.entity.Subscription;
import com.ts.subscription.subscription.data.entity.SubscriptionUserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionValue toSubscriptionValue(Subscription subscription);

    List<SubscriptionValue> toSubscriptionValueList(List<Subscription> subscriptionList);

    SubscriptionUpdateResponse toSubscriptionUpdateResponse(Subscription subscription);

    @Mapping(target = "orderNumber", ignore = true)
    SubscriptionUserInfo mapToSubscriptionUserInfo(SaveSubscriptionUserInfoRequest subscriptionUserInfoRequest);

    default SubscriptionsList toSubscriptionsList(List<Subscription> subscriptionList) {
        List<SubscriptionValue> subscriptionValueList = toSubscriptionValueList(subscriptionList);
        return new SubscriptionsList(subscriptionValueList);
    }
}
