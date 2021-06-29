package com.yalta.telegram.service;

import com.yalta.telegram.Core;
import com.yalta.telegram.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
@Service
@ConditionalOnBean(Config.class)
public class MessageSender implements Runnable {

    @Value("${bot.config.message-sender-sleep-time:3000}")
    private long MESSAGE_SENDER_SLEEP_TIME;
    private final Core core;
    private final ConcurrentLinkedQueue<SendMessage> sendQueue;

    public MessageSender(Core core, ConcurrentLinkedQueue<SendMessage> sendQueue) {
        this.sendQueue = sendQueue;
        this.core = core;

        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.setName("MessageSender");
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (SendMessage message = sendQueue.poll(); message != null; message = sendQueue.poll()) {
                    send(message);
                }
                Thread.sleep(MESSAGE_SENDER_SLEEP_TIME);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void send(SendMessage sendMessage) throws TelegramApiException {
        core.execute(sendMessage);
    }
}
