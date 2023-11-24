package com.ts.subscription.subscription.data.dto;

import java.util.List;
import java.util.UUID;

public record TelegramSendContentRequest(List<TextToSend> textToSendList, UUID subscriptionId) {}
