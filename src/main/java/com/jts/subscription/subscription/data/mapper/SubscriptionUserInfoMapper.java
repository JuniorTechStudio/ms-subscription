package com.jts.subscription.subscription.data.mapper;

import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoRequest;
import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionUserInfoMapper {

    SubscriptionUserInfoDTO mapToSubscriptionUserInfoDTO(SubscriptionUserInfo subscriptionUserInfo);

    @Mapping(target = "order", ignore = true)
    SubscriptionUserInfo mapToSubscriptionUserInfo(SubscriptionUserInfoRequest subscriptionUserInfoRequest);
}
