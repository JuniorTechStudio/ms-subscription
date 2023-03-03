package com.jts.subscription.subscription.data.mapper;

import com.jts.subscription.subscription.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.subscription.data.dto.SaveSubscriptionUserInfoRequest;
import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionUserInfoMapper {

    SubscriptionUserInfoDTO mapToSubscriptionUserInfoDTO(SubscriptionUserInfo subscriptionUserInfo);

    List<SubscriptionUserInfoDTO> mapToSubscriptionUserInfoDTO(List<SubscriptionUserInfo> subscriptionUserInfoList);

    @Mapping(target = "order", ignore = true)
    @Mapping(target = "subscriptionId", ignore = true)
    SubscriptionUserInfo mapToSubscriptionUserInfo(SaveSubscriptionUserInfoRequest subscriptionUserInfoRequest);

}
