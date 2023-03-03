package com.jts.subscription.subscription.repository;

import com.jts.subscription.subscription.data.entity.SubscriptionUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubscriptionUserInfoRepository extends JpaRepository<SubscriptionUserInfo, UUID> {

    List<SubscriptionUserInfo> findAllBySubscriptionTitle(String subscriptionTitle);

    @Transactional
    @Modifying
    @Query("delete from SubscriptionUserInfo s where s.telegramId = ?1 and s.subscriptionTitle = ?2")
    void deleteByTelegramIdAndSubscriptionTitle(String telegramId, String subscriptionTitle);

}
