package com.yalta.telegram.config;

import com.yalta.telegram.TelegramCore;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.concurrent.ConcurrentLinkedQueue;

@Configuration
public class Config {

    @Bean
    @SneakyThrows
    @ConditionalOnBean(TelegramCore.class)
    public BotSession botSession(TelegramCore telegramCore) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        return telegramBotsApi.registerBot(telegramCore);
    }

    @Bean
    public ConcurrentLinkedQueue<SendMessage> sendQueue() {
        return new ConcurrentLinkedQueue<>();
    }

}
