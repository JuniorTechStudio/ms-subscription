package com.jts.subscription.subscription.client;

import com.jts.subscription.subscription.data.dto.PrepareAndSendContentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-content", url = "localhost:8084/")
public interface ContentClient {

    @PostMapping("subscription/send")
    void prepareAndSendContent(@RequestBody PrepareAndSendContentRequest request);

}
