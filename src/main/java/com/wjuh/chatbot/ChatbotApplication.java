package com.wjuh.chatbot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class ChatbotApplication {
    static {
        initBot();
    }

    @Autowired
    private VjuhBot vjuhBot;

    public static void main(String[] args) {
        log.info("Starting app...");
        SpringApplication.run(ChatbotApplication.class, args);
    }

    @PostConstruct
    private void init() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            log.info("Registring bot...");
            telegramBotsApi.registerBot(vjuhBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static void initBot() {
        log.info("Initializing bot context...");
        ApiContextInitializer.init();
    }
}