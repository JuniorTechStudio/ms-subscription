package com.ts.subscription.subscription.client;

import com.ts.subscription.subscription.data.dto.SendContentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-content", url = "${feign.content.url}")
public interface ContentClient {

    @PostMapping("/contents/send")
    void sendContent(@RequestBody SendContentRequest request);

}
