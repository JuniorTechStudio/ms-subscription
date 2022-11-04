package com.jts.subscription.subscription.repository;

import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscriptionUserInfoRepository extends JpaRepository<SubscriptionUserInfo, UUID> {
}
