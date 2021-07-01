package com.yalta.email.service;

import com.yalta.NotificationService;
import com.yalta.email.config.EmailConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnBean(EmailConfig.class)
public class MailMessageService implements NotificationService {

    private final JavaMailSender mailSender;
    private final EmailConfig emailConfig;

    @Override
    public void sendNotification(String payload) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("notification.yalta@gmail.com");
        simpleMailMessage.setTo(emailConfig.getAddressees().toArray(String[]::new));
        simpleMailMessage.setSubject("Notification");
        simpleMailMessage.setText(payload);

        mailSender.send(simpleMailMessage);
    }
}
