package com.yalta.service.email;

import com.yalta.config.Channel;
import com.yalta.config.EmailConfig;
import com.yalta.service.NotificationService;
import lombok.Getter;
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

    @Getter
    private final Channel channel = Channel.EMAIL;

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
