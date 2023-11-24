package com.ts.subscription.subscription.repository;

import com.ts.subscription.subscription.data.entity.SubscriptionUserInfo;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionUserInfoRepository extends JpaRepository<SubscriptionUserInfo, UUID> {
    
  Optional<SubscriptionUserInfo> findBySubscriptionIdAndTelegramId(UUID subscriptionId, String telegramId);

}
