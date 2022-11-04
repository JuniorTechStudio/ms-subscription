package com.jts.subscription.subscription.data.mapper;

import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionUserInfoMapper {

    SubscriptionUserInfoDTO mapToSubscriptionUserInfoDTO(SubscriptionUserInfo subscriptionUserInfo);
}
