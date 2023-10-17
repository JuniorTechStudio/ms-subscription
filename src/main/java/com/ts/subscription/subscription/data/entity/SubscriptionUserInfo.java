package com.ts.subscription.subscription.data.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(schema = "subscription", name = "subscription_user_info")
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionUserInfo {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "telegram_id")
    private String telegramId;

    @Column(name = "subscription_id")
    private UUID subscriptionId;

    @Column(name = "subscription_title")
    private String subscriptionTitle;

    @Column(name = "order_number")
    private int order;

}
