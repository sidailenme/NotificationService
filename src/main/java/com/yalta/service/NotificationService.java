package com.yalta.service;

import com.yalta.config.Channel;

public interface NotificationService {

    void sendNotification(String payload);

    Channel getChannel();

}
