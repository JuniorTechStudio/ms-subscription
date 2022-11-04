package com.jts.subscription.subscription.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "subscription_id")
    private UUID subscriptionId;
    @Column(name = "order_number")
    private Integer order;

}
