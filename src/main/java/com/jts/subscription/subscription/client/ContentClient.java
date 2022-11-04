package com.jts.subscription.subscription.client;

import com.jts.subscription.subscription.data.dto.PrepareAndSendContentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ms-content", url = "http://localhost:8084/subscription")
public interface ContentClient {

    @RequestMapping(method = RequestMethod.POST)
    void PrepareAndSendContentRequest(@RequestBody PrepareAndSendContentRequest prepareAndSendContentRequest);
}
