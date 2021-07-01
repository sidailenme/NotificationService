package com.yalta;

import com.yalta.email.service.MailMessageService;
import com.yalta.telegram.service.TelegramMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("test")
@EnableScheduling
@RequiredArgsConstructor
public class TestClass {

    private final List<NotificationService> serviceList;

    @Scheduled(cron = "0/3 * * * * *")
    public void foo() {
        serviceList.forEach(el -> el.sendNotification("hello" + System.currentTimeMillis()));
    }

}
