package com.ts.subscription.subscription.data.entity;

import jakarta.persistence.*;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(schema = "subscription", name = "subscription_user_info")
@DynamicUpdate
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionUserInfo {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="subscription_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "telegram_id")
    private String telegramId;

    @Column(name = "subscription_id")
    private UUID subscriptionId;

    @Column(name = "order_number")
    private int orderNumber;

}
