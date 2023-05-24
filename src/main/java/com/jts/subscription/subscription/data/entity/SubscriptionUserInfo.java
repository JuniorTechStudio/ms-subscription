package com.jts.subscription.subscription.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.UUID;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_title")
    private SubscriptionTitle subscriptionTitle;

    @Column(name = "order_number")
    private int order;

    public void incrementOrder() {
        this.order++;
    }

}
