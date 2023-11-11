package com.ts.subscription.subscription.repository;

import com.ts.subscription.subscription.data.entity.Subscription;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {

}
