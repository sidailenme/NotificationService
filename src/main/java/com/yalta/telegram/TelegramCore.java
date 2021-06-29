package com.yalta.telegram;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "notification-services.telegram")
public class TelegramCore extends TelegramLongPollingBot {

    @Value("${bot.telegram.name}")
    private String botUsername;
    @Value("${bot.telegram.token}")
    private String botToken;


    @Override
    public void onUpdateReceived(Update update) {
        log.info("RECEIVE >>> From: {}, Text: {}", update.getMessage().getChatId(), update.getMessage().getText());
    }
}
