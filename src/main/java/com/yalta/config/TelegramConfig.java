package com.yalta.config;

import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

@Data
@Configuration
@ConditionalOnBean(TelegramCore.class)
@ConfigurationProperties("telegram.config")
public class TelegramConfig {

    private List<String> consumers;

    @Bean
    @SneakyThrows
    public BotSession botSession(TelegramCore telegramCore) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        return telegramBotsApi.registerBot(telegramCore);
    }
}
