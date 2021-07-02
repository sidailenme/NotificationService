package com.yalta.service.telegram;


import com.yalta.config.Channel;
import com.yalta.config.TelegramConfig;
import com.yalta.config.TelegramCore;
import com.yalta.service.NotificationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@RequiredArgsConstructor
@ConditionalOnBean(TelegramConfig.class)
public class TelegramMessageService implements NotificationService {

    private final TelegramConfig telegramConfig;
    private final TelegramCore telegramCore;

    @Getter
    private final Channel channel = Channel.TELEGRAM;

    @Override
    public void sendNotification(String payload) {
        telegramConfig.getConsumers().stream()
                .map(chatId -> new SendMessage(chatId, payload))
                .forEach(this::execute);
    }

    public void execute(SendMessage message) {
        try {
            telegramCore.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();    //todo
        }
    }
}
