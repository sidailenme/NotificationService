package com.yalta.service;

import com.yalta.config.Channel;
import com.yalta.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final List<NotificationService> serviceList;

    public void sent(Message message) {
        if (message.getChannels() == null || message.getChannels().isEmpty()) {
            message.setChannels(Arrays.stream(Channel.values()).toList());
        }
        serviceList.stream()
                .filter(service -> message.getChannels().contains(service.getChannel()))
                .forEach(service -> service.sendNotification(message.getPayload()));
    }

}
