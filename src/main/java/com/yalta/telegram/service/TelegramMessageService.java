package com.yalta.telegram.service;


import com.yalta.telegram.config.Config;
import com.yalta.telegram.config.ConsumersConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@RequiredArgsConstructor
@ConditionalOnBean(Config.class)
public class TelegramMessageService {

    private final ConcurrentLinkedQueue<SendMessage> sendQueue;
    private final ConsumersConfig consumersConfig;

    public void createMessage(String payload) {
        consumersConfig.getConsumers().stream()
                .map(chatId -> new SendMessage(chatId, payload))
                .forEach(sendQueue::add);
    }
}
