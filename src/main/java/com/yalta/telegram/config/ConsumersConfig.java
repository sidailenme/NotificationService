package com.yalta.telegram.config;

import com.yalta.telegram.TelegramCore;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("bot.telegram")
public class ConsumersConfig {

    private List<String> consumers;

}
