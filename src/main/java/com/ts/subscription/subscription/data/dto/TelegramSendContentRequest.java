package com.ts.subscription.subscription.data.dto;

import java.util.List;

public record TelegramSendContentRequest(List<TextToSend> textToSendList) {}
