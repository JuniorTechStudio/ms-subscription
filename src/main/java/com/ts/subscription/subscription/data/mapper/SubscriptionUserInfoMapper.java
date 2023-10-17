package com.ts.subscription.subscription.data.mapper;

import com.ts.subscription.subscription.data.dto.SubscriptionUserInfoDto;
import com.ts.subscription.subscription.data.dto.SaveSubscriptionUserInfoRequest;
import com.ts.subscription.subscription.data.entity.SubscriptionUserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionUserInfoMapper {

    SubscriptionUserInfoDto mapToSubscriptionUserInfoDTO(SubscriptionUserInfo subscriptionUserInfo);

    List<SubscriptionUserInfoDto> mapToSubscriptionUserInfoDTO(List<SubscriptionUserInfo> subscriptionUserInfoList);

    @Mapping(target = "order", ignore = true)
    SubscriptionUserInfo mapToSubscriptionUserInfo(SaveSubscriptionUserInfoRequest subscriptionUserInfoRequest);

}
