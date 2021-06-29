package com.yalta.telegram;

import com.yalta.telegram.config.ConsumersConfig;
import com.yalta.telegram.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class Test {

//    private final MessageService messageService;

    private final ConsumersConfig consumersConfig;

    @Scheduled(cron = "0/5 * * * * *")
    public void foo() {
//        messageService.createMessage("hello " + System.currentTimeMillis());
        System.out.println("1111111");
        System.out.println(consumersConfig.getConsumers());
    }

}
