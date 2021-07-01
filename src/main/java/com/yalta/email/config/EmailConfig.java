package com.yalta.email.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.List;
import java.util.Properties;

@Data
@Configuration
@ConditionalOnProperty("notification-services.email")
@ConfigurationProperties("email.config")
public class EmailConfig {

    private List<String> addressees;
    private Integer port;
    private String host;
    private String username;
    private String password;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }

}
