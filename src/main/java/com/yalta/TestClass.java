//package com.yalta;
//
//import com.yalta.service.NotificationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Profile;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Profile("test")
//@EnableScheduling
//@RequiredArgsConstructor
//public class TestClass {
//
//    private final List<NotificationService> serviceList;
//
//    @Scheduled(cron = "0/5 * * * * *")
//    public void foo() {
//        System.out.println();
//        serviceList.stream().parallel().forEach(el -> el.sendNotification("hello" + Thread.currentThread().getName()));
//
//
//    }
//
//}
