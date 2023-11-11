package com.ts.subscription.subscription.client;

import com.ts.subscription.subscription.data.dto.TelegramSendContentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-telegram-adapter", url = "${feign.telegram-adapter.url}")
public interface TelegramAdapterClient {

  @PostMapping("/send")
  void sendContent(@RequestBody TelegramSendContentRequest telegramSendContentRequest);

}