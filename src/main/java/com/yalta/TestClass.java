package com.yalta;

import com.yalta.telegram.config.ConsumersConfig;
import com.yalta.telegram.service.TelegramMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
@EnableScheduling
@RequiredArgsConstructor
public class TestClass {


    private final TelegramMessageService telegramMessageService;

    @Scheduled(cron = "0/3 * * * * *")
    public void foo() {
        telegramMessageService.createMessage("hello " + System.currentTimeMillis());
    }

}
