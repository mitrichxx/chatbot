package com.wjuh.chatbot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
@Slf4j
public class ChatbotApplication {
    public static void main(String[] args) {
        initBot();
        log.info("Starting app...");
        SpringApplication.run(ChatbotApplication.class, args);
    }

    private static void initBot() {
        log.info("Initializing bot context...");
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            log.info("Registring bot...");
            telegramBotsApi.registerBot(new VjuhBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}