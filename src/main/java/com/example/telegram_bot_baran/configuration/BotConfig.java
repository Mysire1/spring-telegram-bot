package com.example.telegram_bot_baran.configuration;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotConfig {
    @Getter
    @Value("${bot.token}")
    String token;
    @Value("${spring.application.name}")
    String appName;

}
