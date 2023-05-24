package com.jts.subscription.subscription.client;

import com.jts.subscription.subscription.data.dto.PrepareAndSendContentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-content", url = "${feign.content.url}")
public interface ContentClient {

    @PostMapping("subscription/send")
    void sendContent(@RequestBody PrepareAndSendContentRequest request);

    @PostMapping("word/send/random")
    void sendWord(@RequestBody PrepareAndSendContentRequest request);

}
