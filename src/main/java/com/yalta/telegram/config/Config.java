package com.yalta.telegram.config;

import com.yalta.telegram.Core;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.concurrent.ConcurrentLinkedQueue;

@Configuration
@ConditionalOnProperty(value = "notification-services.telegram")
public class Config {

    @Bean
    @SneakyThrows
    public BotSession botSession(Core core) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        return telegramBotsApi.registerBot(core);
    }

    @Bean
    public ConcurrentLinkedQueue<SendMessage> sendQueue() {
        return new ConcurrentLinkedQueue<>();
    }

}
