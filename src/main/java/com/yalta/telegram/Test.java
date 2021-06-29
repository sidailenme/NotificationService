//package com.yalta.telegram;
//
//import com.yalta.telegram.service.MessageService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//@Service
//@EnableScheduling
//@RequiredArgsConstructor
//public class Test {
//
//    private final MessageService messageService;
//
//    @Scheduled(cron = "0/5 * * * * *")
//    public void foo() {
//        messageService.createMessage("hello " + System.currentTimeMillis());
//
//    }
//
//}
