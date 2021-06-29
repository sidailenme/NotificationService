package com.yalta.telegram.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("bot.telegram")
@ConditionalOnBean(Config.class)
public class ConsumersConfig {

    private List<String> consumers;

}
