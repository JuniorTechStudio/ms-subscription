package com.ts.subscription.subscription.client;

import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-content", url = "${feign.content.url}")
public interface ContentClient {

    @GetMapping("/subscriptions/{subscriptionId}")
    String getContentByOrderNumber(
            @PathVariable UUID subscriptionId,
            @RequestParam("orderNumber") Integer orderNumber
    );

}
