package com.yalta;

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

    @Scheduled(cron = "0/5 * * * * *")
    public void foo() {
        serviceList.forEach(el -> el.sendNotification("hello" + System.currentTimeMillis()));
    }

}
