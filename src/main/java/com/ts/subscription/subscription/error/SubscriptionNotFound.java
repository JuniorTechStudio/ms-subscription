package com.ts.subscription.subscription.error;

import java.util.UUID;

public class SubscriptionNotFound extends RuntimeException {

    private UUID subscriptionId;

    public SubscriptionNotFound(UUID subscriptionId, String message) {
        super(message);
        this.subscriptionId = subscriptionId;
    }

    public SubscriptionNotFound(UUID subscriptionId, String message, Throwable cause) {
        super(message, cause);
        this.subscriptionId = subscriptionId;
    }

}
