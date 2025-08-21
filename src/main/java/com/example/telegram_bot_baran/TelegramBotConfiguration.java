//package com.example.telegram_bot_baran;
//
//import jakarta.annotation.PostConstruct;
//import lombok.SneakyThrows;
//import lombok.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@Configuration
//@PropertySource("classpath:application.properties")
//public class TelegramBotConfiguration {
//
//    @Bean
//    @SneakyThrows
//    public TelegramBot telegramBot(@org.springframework.beans.factory.annotation.Value("${bot.token}") String botToken,
//    TelegramBotsApi telegramBotApi
//    ) {
//        var botOptions = new DefaultBotOptions();
//        var bot = new TelegramBot(botOptions, botToken);
//        telegramBotApi.registerBot(bot);
//        return bot;
//    }
//
//    @Bean
//    @SneakyThrows
//    public TelegramBotsApi telegramBotsApi() {
//        return new TelegramBotsApi(DefaultBotSession.class);
//    }
//}
