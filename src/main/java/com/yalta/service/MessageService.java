package com.yalta.service;

import com.yalta.config.Channel;
import com.yalta.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class MessageService {

    private final List<NotificationService> serviceList;

    public void sent(Message message) {
        if (message.getChannels() == null || message.getChannels().isEmpty()) {
            message.setChannels(Arrays.stream(Channel.values()).toList());
        }
        Set<NotificationService> services = serviceList.stream()
                .filter(service -> message.getChannels().contains(service.getChannel()))
                .collect(Collectors.toSet());
        if (services.isEmpty()) {
            throw new IllegalArgumentException("Sorry. None of the selected service works");
        }       //todo
        services.forEach(service -> service.sendNotification(message.getPayload()));
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void foo() {
        System.out.println("heeeeee");
    }

}
